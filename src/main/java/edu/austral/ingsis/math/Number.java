package edu.austral.ingsis.math;

import java.util.Map;

public class Number implements Function {

  private final double value;

  public Number(double value) {
    this.value = value;
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> mapValues) {
    return new Try<>(value);
  }

  @Override
  public String printFunction() {
    return String.valueOf(value);
  }
}
