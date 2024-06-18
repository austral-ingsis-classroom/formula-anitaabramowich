package edu.austral.ingsis.math;

import java.util.List;
import java.util.Map;

public interface Function {

  public Try<Double, Exception> resolve(Map<String, Double> mapValues);

  String printFunction();

  public List<String> listVariables();
}
