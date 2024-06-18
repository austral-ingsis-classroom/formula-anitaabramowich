package edu.austral.ingsis.math;

import java.util.Map;

public abstract class Binary implements Function {

  protected final Function left;
  protected final Function right;

  public Binary(Function left, Function right) {
    this.left = left;
    this.right = right;
  }

  @Override
  public abstract Try<Double, Exception> resolve(Map<String, Double> mapValues);

  @Override
  public abstract String printFunction();
}

