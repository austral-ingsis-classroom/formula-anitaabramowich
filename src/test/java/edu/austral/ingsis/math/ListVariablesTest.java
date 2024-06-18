package edu.austral.ingsis.math;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function left = new Number(1);
    Function right = new Number(6);
    Sum addition = new Sum(left, right);

    final List<String> result = addition.listVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function left = new Number(12);
    Function div = new Variable("div");
    Map<String, Double> variables = new HashMap<>();
    variables.put("div", 4.0);
    Div result = new Div(left, div);

    assertThat(result.listVariables(), containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function left = new Div(new Number(9), new Variable("x"));
    Function right = new Variable("y");
    Multiply multiplication = new Multiply(left, right);

    final List<String> result = multiplication.listVariables();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function left = new Div(new Number(27), new Variable("a"));
    Function right = new Variable("b");
    Pow exponentiation = new Pow(left, right);

    final List<String> result = exponentiation.listVariables();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function base = new Variable("z");
    Function exponent = new Number(0.5);
    Pow exponentiation = new Pow(base, exponent);

    final List<String> result = exponentiation.listVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function abs = new Abs(new Variable("value"));
    Function subtraction = new Sub(abs, new Number(8));

    final List<String> result = subtraction.listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function abs = new Abs(new Variable("value"));
    Function subtraction = new Sub(abs, new Number(8));

    final List<String> result = subtraction.listVariables();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function subtraction = new Sub(new Number(5), new Variable("i"));
    Function multiplication = new Multiply(subtraction, new Number(8));

    final List<String> result = multiplication.listVariables();

    assertThat(result, containsInAnyOrder("i"));
  }
}
