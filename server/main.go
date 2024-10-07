package main

import (
	"log"
	"net"

	"google.golang.org/grpc"
	"google.golang.org/grpc/reflection"

	"github.com/AlejandroJRosas/cen-project/modules/calculator"
	pbCalc "github.com/AlejandroJRosas/cen-project/pb/calculator"

	"github.com/AlejandroJRosas/cen-project/modules/greeter"
	pbGreeter "github.com/AlejandroJRosas/cen-project/pb/greeter"
)

const (
	port = ":8080"
)

func main() {
	listener, err := net.Listen("tcp", port)
	if err != nil {
		log.Fatalf("Failed to listen on port [%v]: %v", port, err)
	}

	s := grpc.NewServer()
	reflection.Register(s)

	pbCalc.RegisterCalculatorServer(s, &calculator.CalculatorServer{})
	pbGreeter.RegisterGreeterServer(s, &greeter.GreeterServer{})

	log.Printf("gRPC server running on %v", listener.Addr())

	if err := s.Serve(listener); err != nil {
		log.Fatalf("Failed to serve gRPC server over port [%v]: %v", port, err)
	}
}
