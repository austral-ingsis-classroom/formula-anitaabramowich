package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function left = new Number(1);
    Function right = new Number(6);
    Sum addition = new Sum(left, right);

    assertThat(addition.resolve(null).getSuccess(), equalTo(7.0));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function left = new Number(12);
    Function right = new Number(2);
    Div division = new Div(left, right);

    assertThat(division.resolve(null).getSuccess(), equalTo(6.0));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Div left = new Div(new Number(9), new Number(2));
    Function right = new Number(3);
    Multiply multiplication = new Multiply(left, right);

    assertThat(multiplication.resolve(null).getSuccess(), equalTo(13.5));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Div left = new Div(new Number(27), new Number(6));
    Function right = new Number(2);
    Pow power = new Pow(left, right);

    assertThat(power.resolve(null).getSuccess(), equalTo(20.25));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function left = new Number(36);
    Div right = new Div(new Number(1), new Number(2));
    Pow power = new Pow(left, right);

    assertThat(power.resolve(null).getSuccess(), equalTo(6.0));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function value = new Number(136);
    Abs absolute = new Abs(value);

    assertThat(absolute.resolve(null).getSuccess(), equalTo(136.0));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function value = new Number(-136);
    Abs absolute = new Abs(value);

    assertThat(absolute.resolve(null).getSuccess(), equalTo(136.0));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function left = new Sub(new Number(5), new Number(5));
    Function right = new Number(8);
    Multiply multiplication = new Multiply(left, right);

    assertThat(multiplication.resolve(null).getSuccess(), equalTo(0.0));
  }
}
