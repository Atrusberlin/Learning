package de.dranke.learning.ooplecture.rpncalculator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CalculatorTest {

  private Calculator calculator;

  @BeforeMethod
  protected void setUp() throws Exception {
    calculator = new Calculator();
  }

  @Test
  public void enter() {
    //given
    assertThat(calculator.stack.isEmpty()).isTrue();

    // when
    int result = calculator.enter(3);

    // then
    assertThat(result).isEqualTo(3);
    assertThat(calculator.stack.size()).isEqualTo(1);
    assertThat(calculator.stack.peek()).isEqualTo(3);
  }

  @Test
  public void minus_with_empty_stack() {
    // given
    assertThat(calculator.stack.isEmpty()).isTrue();
    // when
    int actual = calculator.perform("-");

    // then
    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void minus__only_one_item_on_stack() {
    // given
    calculator.enter(3);

    // when
    int result = calculator.perform("-");

    // then
    assertThat(result).isEqualTo(-3);
    assertThat(calculator.stack.size()).isEqualTo(1);
    assertThat(calculator.stack.peek()).isEqualTo(-3);
  }

  @Test
  public void minus__two_items_on_stack() {
    // given
    calculator.enter(6);
    calculator.enter(2);

    // when
    int result = calculator.perform("-");

    // then
    assertThat(result).isEqualTo(4);
    assertThat(calculator.stack.size()).isEqualTo(1);
    assertThat(calculator.stack.peek()).isEqualTo(4);
  }

  @Test
  public void plus_with_empty_stack() {
    // given
    assertThat(calculator.stack.isEmpty()).isTrue();
    // when
    int actual = calculator.perform("+");

    // then
    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void plus__only_one_item_on_stack() {
    // given
    calculator.enter(3);

    // when
    int result = calculator.perform("+");

    // then
    assertThat(result).isEqualTo(3);
    assertThat(calculator.stack.size()).isEqualTo(1);
    assertThat(calculator.stack.peek()).isEqualTo(3);
  }

  @Test
  public void plus__two_items_on_stack() {
    // given
    calculator.enter(6);
    calculator.enter(2);

    // when
    int result = calculator.perform("+");

    // then
    assertThat(result).isEqualTo(8);
    assertThat(calculator.stack.size()).isEqualTo(1);
    assertThat(calculator.stack.peek()).isEqualTo(8);
  }

  @Test
  public void factorial_4_returns_24() {
    // given
    calculator.enter(4);
    // when
    int result = calculator.perform("!");
    // then
    assertThat(result).isEqualTo(24);
    assertThat(calculator.stack.size()).isEqualTo(1);
    assertThat(calculator.stack.peek()).isEqualTo(24);
  }

  @Test
  public void factorial_with_empty_stack() {
    // given
    assertThat(calculator.stack.isEmpty()).isTrue();
    // when
    int actual = calculator.perform("!");

    // then
    assertThat(actual).isEqualTo(0);
  }

  @Test
  public void multiply() {
    // setup
    OperationFactory factory = mock(OperationFactory.class);
    when(factory.getOperation("*")).thenReturn(new Multiply());
    Stack stack = new Stack();
    calculator = new Calculator(factory, stack);

    // given
    calculator.enter(4);
    calculator.enter(6);

    // when
    int result = calculator.perform("*");

    // then
    verify(factory).getOperation("*");
    assertThat(result).isEqualTo(24);
  }

  @Test
  public void divide() {
    // given
    calculator.enter(12);
    calculator.enter(4);

    // when
    int result = calculator.perform("/");

    // then
    assertThat(result).isEqualTo(3);
  }
}
