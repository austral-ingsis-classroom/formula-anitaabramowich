package edu.austral.ingsis.math;

import java.util.Map;

public class Sqrt extends Unary {

  public Sqrt(Function function) {
    super(function);
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> mapValues) {
    Try<Double, Exception> functionResult = function.resolve(mapValues);

    if (functionResult.isFail()) {
      return new Try<>(functionResult.getFail());
    }

    if (functionResult.getSuccess() < 0) {
      return new Try<>(new Exception("No se puede realizar la operacion"));
    }

    double result = Math.sqrt(functionResult.getSuccess());
    return new Try<>(result);
  }

  @Override
  public String printFunction() {
    return "sqrt(" + function.printFunction() + ")";
  }
}
