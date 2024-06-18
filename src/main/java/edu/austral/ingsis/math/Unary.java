package edu.austral.ingsis.math;

import java.util.Map;

public abstract class Unary implements Function {

  protected final Function function;

  public Unary(Function function) {
    this.function = function;
  }

  @Override
  public abstract Try<Double, Exception> resolve(Map<String, Double> mapValues);

  @Override
  public abstract String printFunction();
}