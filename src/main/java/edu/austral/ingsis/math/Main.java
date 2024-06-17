package edu.austral.ingsis.math;

public class Main {

  public static void main(String[] args) {

    Function left = new Number(1);
    Function right = new Number(6);
    Function addition = new Binary(left, right, "+");

    System.out.println(addition.printFunction());

    System.out.println(addition.resolve(null).getSuccess());

  }
}
