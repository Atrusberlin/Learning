package de.dranke.learning.ooplecture.rpncalculator;

public class Calculator {

  Stack stack = new Stack();
  private OperationFactory operationFactory;

  public Calculator() {
    this(new OperationFactory(), new Stack());
  }

  Calculator(OperationFactory operationFactory, Stack stack) {
    this.operationFactory = operationFactory;
    this.stack = stack;
  }

  public int enter(int number) {
    stack.push(number);
    return stack.peek();
  }

  public int perform(String operator) {
    return operationFactory.getOperation(operator).execute(stack);
  }
}
