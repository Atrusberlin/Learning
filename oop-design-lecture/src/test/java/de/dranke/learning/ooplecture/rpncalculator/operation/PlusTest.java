package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Stack;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PlusTest {

  private Stack stack;
  private Plus plus;

  @BeforeMethod
  public void setUp() {
    plus = new Plus();
    stack = new Stack();
  }

  @Test
  public void plus_with_empty_stack() {
    // given
    assertThat(stack.isEmpty()).isTrue();
    // when
    int actual = plus.execute(stack);

    // then
    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void plus__only_one_item_on_stack() {
    // given
    stack.push(3);

    // when
    int result = plus.execute(stack);

    // then
    assertThat(result).isEqualTo(3);
    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.peek()).isEqualTo(3);
  }

  @Test
  public void plus__two_items_on_stack() {
    // given
    stack.push(6);
    stack.push(2);

    // when
    int result = plus.execute(stack);

    // then
    assertThat(result).isEqualTo(8);
    assertThat(stack.size()).isEqualTo(1);
    assertThat(stack.peek()).isEqualTo(8);
  }
}
