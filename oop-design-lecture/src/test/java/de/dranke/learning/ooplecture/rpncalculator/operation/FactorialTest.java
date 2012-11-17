package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Stack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class FactorialTest {

  private Stack stack;
  private Factorial factorial;

  @BeforeMethod
  public void setUp() {
    factorial = new Factorial();
    stack = new Stack();
  }

  @Test
  public void factorial_4_returns_24() {
    // given
    stack.push(4);
    // when
    int actual = factorial.execute(stack);

    // then

    assertThat(actual).isEqualTo(24);
    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.peek()).isEqualTo(24);
  }

  @Test
  public void factorial_with_empty_stack() {
    // given
    assertThat(stack.isEmpty()).isTrue();
    // when
    int actual = factorial.execute(stack);

    // then
    assertThat(actual).isEqualTo(0);
  }
}
