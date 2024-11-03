package greeter

import (
	"context"

	"github.com/AlejandroJRosas/cen-project/pb/greeter"
	"google.golang.org/protobuf/types/known/emptypb"
)

type GreeterServer struct {
	greeter.UnimplementedGreeterServer
}

func (s *GreeterServer) SayHello(
	ctx context.Context,
	req *emptypb.Empty,
) (*greeter.HelloResponse, error) {
	return &greeter.HelloResponse{
		Message: "Hello From the Server!",
	}, nil
}
