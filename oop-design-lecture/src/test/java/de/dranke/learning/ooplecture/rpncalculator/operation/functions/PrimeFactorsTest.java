package de.dranke.learning.ooplecture.rpncalculator.operation.functions;

import de.dranke.learning.ooplecture.rpncalculator.Stack;
import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class PrimeFactorsTest {

  @Test
  public void execute_1() {
    // given
    PrimeFactors primeFactors = new PrimeFactors();
    Stack stack = new Stack();
    stack.push(1);

    // when
    primeFactors.execute(stack);

    // then
    assertThat(stack.isEmpty()).isTrue();
  }

  @DataProvider
  public Object[][] oneFactor() {
    return new Object[][] {
        {2, "2"},
        {3, "3"},
        {4, "2 2"},
        {5, "5"},
        {6, "2 3"},
        {8, "2 2 2"},
        {9, "3 3"},
        {10, "2 5"},
        {15, "3 5"},
        {39, "3 13"},
        {64, "2 2 2 2 2 2"},
    };
  }

  @Test(dataProvider = "oneFactor")
  public void execute_one_argument(int input, String expected) {
    // given
    PrimeFactors primeFactors = new PrimeFactors();
    Stack stack = new Stack();
    stack.push(input);

    // when
    primeFactors.execute(stack);

    // then
    int[] expectedInts = getIntArray(expected);
    assertThat(stack.size()).isEqualTo(expectedInts.length);
    for (int expectedNumber : expectedInts) {
      assertThat(stack.pop()).isEqualTo(expectedNumber);
    }
  }

  private int[] getIntArray(String expected) {
    String[] strings = expected.split(" ");
    int[] ints = new int[strings.length];
    for (int i = 0; i < strings.length; i++) {
      ints[i] = Integer.parseInt(strings[i]);
    }
    return ints;
  }
}
