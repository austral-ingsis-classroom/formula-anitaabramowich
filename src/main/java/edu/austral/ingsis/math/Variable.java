package edu.austral.ingsis.math;

import java.util.Map;

public class Variable implements Function {

  private final String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> mapValues) {
    if (mapValues.containsKey(name)) {
      return new Try<>(mapValues.get(name));
    } else {
      return new Try<>(new Exception("No se encontro la variable"));
    }
  }

  @Override
  public String printFunction() {
    return name;
  }
}
