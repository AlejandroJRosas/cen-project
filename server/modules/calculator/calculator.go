package calculator

import (
	"context"

	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"

	"github.com/AlejandroJRosas/cen-project/pb/calculator"
)

type CalculatorServer struct {
	calculator.UnimplementedCalculatorServer
}

func (s *CalculatorServer) Add(
	ctx context.Context,
	in *calculator.CalculationRequest,
) (*calculator.CalculationResponse, error) {
	return &calculator.CalculationResponse{Result: in.A + in.B}, nil
}

func (s *CalculatorServer) Divide(
	ctx context.Context,
	in *calculator.CalculationRequest,
) (*calculator.CalculationResponse, error) {
	if in.B == 0 {
		return nil, status.Error(codes.InvalidArgument, "Cannot divide by zero")
	}
	return &calculator.CalculationResponse{Result: in.A / in.B}, nil
}

func (s *CalculatorServer) Sum(
	ctx context.Context,
	in *calculator.NumbersRequest,
) (*calculator.CalculationResponse, error) {
	var sum int64

	for _, num := range in.Numbers {
		sum += num
	}

	return &calculator.CalculationResponse{Result: sum}, nil
}
