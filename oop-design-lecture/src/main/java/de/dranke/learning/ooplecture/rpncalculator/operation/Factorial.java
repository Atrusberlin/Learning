package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Stack;

class Factorial implements Operation {

  @Override
  public final int execute(Stack stack) {
    int number = stack.pop();
    int result = factorial(number);
    stack.push(result);
    return result;
  }

  private int factorial(int number) {
    return number > 1 ? number * factorial(--number) : number;
  }
}
