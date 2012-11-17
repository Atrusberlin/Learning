package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Stack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TimesTest {

  private Stack stack;
  private Times times;

  @BeforeMethod
  public void setUp() {
    times = new Times();
    stack = new Stack();
  }

  @Test
  public void multiply() {
    // setup

    // given
    stack.push(4);
    stack.push(6);

    // when
    int actual = times.execute(stack);

    // then

    assertThat(actual).isEqualTo(24);
  }
}
