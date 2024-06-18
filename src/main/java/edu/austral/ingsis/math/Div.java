package edu.austral.ingsis.math;

import java.util.Map;

public class Div extends Binary {

    public Div(Function left, Function right) {
        super(left, right);
    }

    @Override
    public Try<Double, Exception> resolve(Map<String, Double> mapValues) {
        Try<Double, Exception> leftResult = left.resolve(mapValues);
        Try<Double, Exception> rightResult = right.resolve(mapValues);

        if (leftResult.isFail()) {
            return new Try<>(leftResult.getFail());
        }

        if (rightResult.isFail() || rightResult.getSuccess() == 0) {
            return new Try<>(new Exception("No se pudo realizar la operacion"));
        }

        double result = leftResult.getSuccess() / rightResult.getSuccess();
        return new Try<>(result);
    }

    @Override
    public String printFunction() {
        return "(" + left.printFunction() + " / " + right.printFunction() + ")";
    }

}
