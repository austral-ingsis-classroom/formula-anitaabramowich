package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function left = new Number(1);
    Function x = new Variable("x");
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);
    Sum addition = new Sum(left, x);

    assertThat(addition.resolve(variables).getSuccess(), equalTo(4.0));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Function left = new Number(12);
    Function div = new Variable("div");
    Map<String, Double> variables = new HashMap<>();
    variables.put("div", 4.0);
    Function division = new Div(left, div);

    assertThat(division.resolve(variables).getSuccess(), equalTo(3.0));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function cons = new Number(9);
    Function x = new Variable("x");
    Function y = new Variable("y");
    Map<String, Double> variables = new HashMap<>();
    variables.put("x", 3.0);
    variables.put("y", 4.0);
    Div division = new Div(cons, x);
    Multiply multiplication = new Multiply(division, y);

    assertThat(multiplication.resolve(variables).getSuccess(), equalTo(12.0));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function cons = new Number(27);
    Function a = new Variable("a");
    Function b = new Variable("b");
    Map<String, Double> variables = new HashMap<>();
    variables.put("a", 9.0);
    variables.put("b", 3.0);
    Div division = new Div(cons, a);
    Pow power = new Pow(division, b);

    assertThat(power.resolve(variables).getSuccess(), equalTo(27.0));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function z = new Variable("z");
    Map<String, Double> variables = new HashMap<>();
    variables.put("z", 36.0);
    Pow power = new Pow(z, new Number(0.5));

    assertThat(power.resolve(variables).getSuccess(), equalTo(6.0));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Function value = new Variable("value");
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", 8.0);
    Abs abs = new Abs(value);
    Sub subtraction = new Sub(abs, new Number(8));

    assertThat(subtraction.resolve(variables).getSuccess(), equalTo(0.0));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Function value = new Variable("value");
    Map<String, Double> variables = new HashMap<>();
    variables.put("value", 8.0);
    Abs abs = new Abs(value);
    Sub subtraction = new Sub(abs, new Number(8));

    assertThat(subtraction.resolve(variables).getSuccess(), equalTo(0.0));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Function left = new Number(5);
    Function i = new Variable("i");
    Map<String, Double> variables = new HashMap<>();
    variables.put("i", 2.0);
    Sub subtraction = new Sub(left, i);
    Multiply multiplication = new Multiply(subtraction, new Number(8));

    assertThat(multiplication.resolve(variables).getSuccess(), equalTo(24.0));
  }
}
