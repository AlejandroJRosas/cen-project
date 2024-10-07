package greeter

import (
	"context"

	"github.com/AlejandroJRosas/cen-project/pb/greeter"
)

type GreeterServer struct {
	greeter.UnimplementedGreeterServer
}

func (s *GreeterServer) SayHello(
	ctx context.Context,
	req *greeter.NoParam,
) (*greeter.HelloResponse, error) {
	return &greeter.HelloResponse{
		Message: "Hello From the Server!",
	}, nil
}
