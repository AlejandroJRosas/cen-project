package lobby

import (
	"context"
	"log"
	"sync"

	"github.com/AlejandroJRosas/cen-project/pb/lobby"
)

type LobbyServer struct {
	lobby.UnimplementedLobbyServer
	players      []*lobby.Player
	mu           sync.Mutex
	playerStream map[*lobby.Player]lobby.Lobby_StreamLobbyServer
}

func (s *LobbyServer) EnterLobby(ctx context.Context, req *lobby.EnterLobbyRequest) (*lobby.LobbyResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	if len(s.players) >= 12 {
		return &lobby.LobbyResponse{Message: "Lobby is full!", Players: s.players}, nil
	}

	for _, player := range s.players {
		if player.Name == req.PlayerName {
			return &lobby.LobbyResponse{Message: "That name is already taken!", Players: s.players}, nil
		}
	}

	newPlayer := &lobby.Player{Name: req.PlayerName, Team: 0, IsReady: false}
	s.players = append(s.players, newPlayer)

	playersPtr := append([]*lobby.Player{}, s.players...)

	s.broadcastPlayerStatus(newPlayer)

	return &lobby.LobbyResponse{
		Message: "Welcome to the lobby!",
		Players: playersPtr,
	}, nil
}

func (s *LobbyServer) LeaveLobby(ctx context.Context, req *lobby.LeaveLobbyRequest) (*lobby.LeaveLobbyResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	player := &lobby.Player{}
	for i, item := range s.players {
		if item.Name == req.PlayerName {
			s.players = append(s.players[:i], s.players[i+1:]...)
			player = item
			break
		}
	}

	s.broadcastPlayerStatus(player)

	return &lobby.LeaveLobbyResponse{
		Message: "You have left the lobby.",
	}, nil
}

func (s *LobbyServer) StreamLobby(stream lobby.Lobby_StreamLobbyServer) error {
	var player *lobby.Player

	for {
		update, err := stream.Recv()
		if err != nil {
			log.Printf("Error receiving update: %v", err)
			return err
		}

		s.mu.Lock()
		if player == nil {
			player = update.Player
			s.playerStream[player] = stream
		}

		if update.IsJoining {
			playerExists := false
			for _, p := range s.players {
				if p.Name == update.Player.Name {
					playerExists = true
					break
				}
			}
			if !playerExists {
				s.players = append(s.players, update.Player)
			}
		} else {
			for i, p := range s.players {
				if p.Name == update.Player.Name {
					s.players = append(s.players[:i], s.players[i+1:]...)
					break
				}
			}
		}
		s.mu.Unlock()

		s.broadcastPlayerStatus(update.Player)
	}
}

func (s *LobbyServer) SelectTeam(ctx context.Context, req *lobby.SelectTeamRequest) (*lobby.LobbyResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	player := &lobby.Player{}
	for _, item := range s.players {
		if item.Name == req.PlayerName {
			item.Team = req.SelectedTeam
			player = item
			break
		}
	}

	s.broadcastPlayerStatus(player)

	return &lobby.LobbyResponse{
		Message: "Team selected!",
		Players: append([]*lobby.Player{}, s.players...),
	}, nil
}

func (s *LobbyServer) UpdateIsReady(ctx context.Context, req *lobby.UpdateIsReadyRequest) (*lobby.UpdateIsReadyResponse, error) {
	s.mu.Lock()
	defer s.mu.Unlock()

	player := &lobby.Player{}
	for _, item := range s.players {
		if item.Name == req.PlayerName {
			item.IsReady = req.IsReady
			player = item
			break
		}
	}

	ready := true
	for _, item := range s.players {
		if !item.IsReady {
			ready = false
			break
		}
	}

	s.broadcastPlayerStatus(player)

	return &lobby.UpdateIsReadyResponse{
		Message:  "Ready status updated!",
		AllReady: ready,
	}, nil
}

func (s *LobbyServer) broadcastPlayerStatus(player *lobby.Player) {
	for _, stream := range s.playerStream {
		if stream != nil {
			if err := stream.Send(&lobby.LobbyStatus{
				Player:              player,
				AmountActivePlayers: int32(len(s.players)),
			}); err != nil {
				log.Printf("Failed to send message to stream: %v", err)
			}
		}
	}
}
