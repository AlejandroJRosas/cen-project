package main

import (
	"log"
	"net"
	"os"
	"strconv"

	_ "github.com/joho/godotenv/autoload"

	"google.golang.org/grpc"
	"google.golang.org/grpc/reflection"

	"github.com/AlejandroJRosas/cen-project/internal/calculator"
	"github.com/AlejandroJRosas/cen-project/internal/greeter"

	pbCalc "github.com/AlejandroJRosas/cen-project/pb/calculator"
	pbGreeter "github.com/AlejandroJRosas/cen-project/pb/greeter"
)

func main() {
	port, err := strconv.Atoi(os.Getenv("PORT"))

	if err != nil {
		port = 8080
	}

	listener, err := net.Listen("tcp", ":"+strconv.Itoa(port))

	if err != nil {
		log.Fatalf("Failed to listen on port [%v]: %v", port, err)
	}

	s := grpc.NewServer()
	reflection.Register(s)

	pbGreeter.RegisterGreeterServer(s, &greeter.GreeterServer{})
	pbCalc.RegisterCalculatorServer(s, &calculator.CalculatorServer{})

	log.Printf("gRPC server running on %v", listener.Addr())

	if err := s.Serve(listener); err != nil {
		log.Fatalf("Failed to serve gRPC server over port [%v]: %v", port, err)
	}
}
