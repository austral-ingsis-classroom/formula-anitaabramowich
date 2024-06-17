package edu.austral.ingsis.math;

import java.util.Map;

public class Binary implements Function {

  private final Function left;
  private final Function right;
  private final String operator;

  public Binary(Function left, Function right, String operator) {
    this.left = left;
    this.right = right;
    this.operator = operator;
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> mapValues) {

    Try<Double, Exception> leftResult = left.resolve(mapValues);
    Try<Double, Exception> rightResult = right.resolve(mapValues);

    if (leftResult.isFail() || rightResult.isFail()) {
      return new Try<>(new Exception("Error encontrando el valor"));
    }

    try {
      double leftValue = leftResult.getSuccess();
      double rightValue = rightResult.getSuccess();
      double result;
      switch (operator) {
        case "+":
          result = leftValue + rightValue;
          break;
        case "-":
          result = leftValue - rightValue;
          break;
        case "*":
          result = leftValue * rightValue;
          break;
        case "/":
          result = leftValue / rightValue;
          break;
        case "^":
          result = Math.pow(leftValue, rightValue);
          break;
        case "%":
          result = leftValue % rightValue;
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
    return "(" + left.printFunction() + " " + operator + " " + right.printFunction() + ")";
  }
}
