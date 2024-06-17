package edu.austral.ingsis.math;

import java.util.Map;

public class Unary implements Function {

  private final Function function;
  private final String operator;

  public Unary(Function function, String operator) {
    this.function = function;
    this.operator = operator;
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> mapValues) {

    Try<Double, Exception> functionResult = function.resolve(mapValues);

    if (functionResult.isFail()) {
      return new Try<>(new Exception("Error encontrando el valor"));
    }

    try {
      double value = functionResult.getSuccess();
      double result;
      switch (operator) {
        case "sqrt":
          result = Math.sqrt(value);
          break;
        case "-":
          result = -value;
          break;
        case "|":
          result = Math.abs(value);
          break;
        default:
          return new Try<>(new IllegalArgumentException("Operador invalido"));
      }
      return new Try<>(result);
    } catch (Exception e) {
      return new Try<>(e);
    }
  }

  @Override
  public String printFunction() {
    return operator + "(" + function.printFunction() + ")";
  }
}
