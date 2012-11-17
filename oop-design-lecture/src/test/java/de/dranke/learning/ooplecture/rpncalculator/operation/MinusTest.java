package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Stack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class MinusTest {

  private Stack stack;
  private Minus minus;

  @BeforeMethod
  public void setUp() {
    minus = new Minus();
    stack = new Stack();
  }

  @Test
  public void minus_with_empty_stack() {
    // given
    assertThat(stack.isEmpty()).isTrue();
    // when
    int actual = minus.execute(stack);

    // then
    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void minus__only_one_item_on_stack() {
    // given
    stack.push(3);

    // when
    int actual = minus.execute(stack);

    // then
    assertThat(actual).isEqualTo(-3);
    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.peek()).isEqualTo(-3);
  }

  @Test
  public void minus__two_items_on_stack() {
    // given
    stack.push(6);
    stack.push(2);

    // when
    int actual = minus.execute(stack);

    // then
    assertThat(actual).isEqualTo(4);
    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.peek()).isEqualTo(4);
  }
}
