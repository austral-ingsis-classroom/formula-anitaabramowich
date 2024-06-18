package edu.austral.ingsis.math;

import java.util.Map;

public class Sum extends Binary {

    public Sum(Function left, Function right) {
        super(left, right);
    }

    @Override
    public Try<Double, Exception> resolve(Map<String, Double> mapValues) {
        Try<Double, Exception> leftResult = left.resolve(mapValues);
        Try<Double, Exception> rightResult = right.resolve(mapValues);

        if (leftResult.isFail()) {
            return new Try<>(leftResult.getFail());
        }

        if (rightResult.isFail()) {
            return new Try<>(rightResult.getFail());
        }

        double result = leftResult.getSuccess() + rightResult.getSuccess();
        return new Try<>(result);
    }

    @Override
    public String printFunction() {
        return "(" + left.printFunction() + " + " + right.printFunction() + ")";
    }

}
