package de.dranke.learning.ooplecture.rpncalculator;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;

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
  public void calculator() {
    // given

    // when
    calculator.enter(4);
    int actual = calculator.perform("+");

    // then
    assertThat(actual).isEqualTo(4);
  }

  @Test
  public void Macro_Acceptance_Test() {
    // given
    calculator.startMacro();
    calculator.perform("+");
    calculator.perform("*");
    calculator.perform("-");
    calculator.saveMacro("test");
    calculator.enter(3);
    calculator.enter(5);
    calculator.enter(2);
    calculator.enter(13);

    // when
    int actual = calculator.perform("test");

    // then
    assertThat(actual).isEqualTo(-72);
  }
}
