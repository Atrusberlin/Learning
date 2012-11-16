package de.dranke.learning.ooplecture.rpncalculator;

public abstract class OperationOneNumber implements Operation {

  @Override
  public final int execute(Stack stack) {
    int number = stack.pop();
    int result = calculate(number);
    stack.push(result);
    return result;
  }

  protected abstract int calculate(int number);
}
