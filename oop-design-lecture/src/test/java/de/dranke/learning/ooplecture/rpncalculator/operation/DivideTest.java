package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Stack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class DivideTest {

  private Stack stack;
  private Divide divide;

  @BeforeMethod
  public void setUp() {
    divide = new Divide();
    stack = new Stack();
  }

  @Test
  public void divide() {
    // given
    stack.push(12);
    stack.push(4);
    // when
    int actual = divide.execute(stack);

    // then
    assertThat(actual).isEqualTo(3);
  }
}
