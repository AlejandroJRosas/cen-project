DEFAULT_PORT := 8080

generate:
	protoc proto/*.proto --go_out=./server --go-grpc_out=./server
	protoc proto/*.proto --java_out=./client

grpcui:
	grpcui -plaintext localhost:$(DEFAULT_PORT)

build:
	go build -C server -o ../bin/server.exe main.go

run:
	bin/server.exe
