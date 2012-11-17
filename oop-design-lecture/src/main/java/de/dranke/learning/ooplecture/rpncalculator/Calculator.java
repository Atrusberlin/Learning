package de.dranke.learning.ooplecture.rpncalculator;

import de.dranke.learning.ooplecture.rpncalculator.operation.Operation;
import de.dranke.learning.ooplecture.rpncalculator.operation.OperationFactory;

public class Calculator {

  Stack stack = new Stack();
  private OperationFactory operationFactory;
  private Macro macro;

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
    Operation operation = operationFactory.getOperation(operator);
    if (macro == null) {
      return operation.execute(stack);
    }
    else {
      macro.add(operation);
      return stack.peek();
    }
  }

  public void startMacro() {
    macro = new Macro();
  }

  public void saveMacro(String name) {
    macro.setName(name);
    operationFactory.addMacro(macro);
    macro = null;
  }
}
