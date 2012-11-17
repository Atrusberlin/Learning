package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Stack;

abstract class OperationTwoNumbers implements Operation {

  @Override
  public final int execute(Stack stack) {
    int right = stack.pop();
    int left = stack.pop();
    int result = calculate(left, right);
    stack.push(result);
    return result;
  }

  protected abstract int calculate(int left, int right);
}
