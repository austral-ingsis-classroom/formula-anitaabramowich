package edu.austral.ingsis.math;

import java.util.Map;

public interface Function {

  public Try<Double, Exception> resolve(Map<String, Double> mapValues);

  public String printFunction();
}
