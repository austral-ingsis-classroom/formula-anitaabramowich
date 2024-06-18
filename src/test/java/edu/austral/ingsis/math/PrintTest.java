package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    Function left = new Number(1);
    Function right = new Number(6);
    Sum addition = new Sum(left, right);

    assertThat(addition.printFunction(), equalTo("(1.0 + 6.0)"));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    Function left = new Number(12);
    Function right = new Number(2);
    Div division = new Div(left, right);

    assertThat(division.printFunction(), equalTo("(12.0 / 2.0)"));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Function division = new Div(new Number(9), new Number(2));
    Function multiplication = new Multiply(division, new Number(3));

    assertThat(multiplication.printFunction(), equalTo("((9.0 / 2.0) * 3.0)"));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Div division = new Div(new Number(27), new Number(6));
    Pow exponentiation = new Pow(division, new Number(2));

    assertThat(exponentiation.printFunction(), equalTo("((27.0 / 6.0) ^ 2.0)"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    Function value = new Variable("value");
    Function abs = new Abs(value);
    Function subtraction = new Sub(abs, new Number(8));

    assertThat(subtraction.printFunction(), equalTo("(|value| - 8.0)"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    Function left = new Number(5);
    Function right = new Variable("i");
    Function subtraction = new Sub(left, right);
    Function multiplication = new Multiply(subtraction, new Number(8));

    assertThat(multiplication.printFunction(), equalTo("((5.0 - i) * 8.0)"));
  }
}
