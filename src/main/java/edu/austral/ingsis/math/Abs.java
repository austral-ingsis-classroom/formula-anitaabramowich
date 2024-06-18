package edu.austral.ingsis.math;

import java.util.Map;

public class Abs extends Unary {

  public Abs(Function function) {
    super(function);
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> mapValues) {
    Try<Double, Exception> functionResult = function.resolve(mapValues);

    if (functionResult.isFail()) {
      return new Try<>(functionResult.getFail());
    }

    double result = Math.abs(functionResult.getSuccess());
    return new Try<>(result);
  }

  @Override
  public String printFunction() {
    return "|" + function.printFunction() + "|";
  }
}
