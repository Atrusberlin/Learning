package de.dranke.learning.ooplecture.rpncalculator;

import de.dranke.learning.ooplecture.rpncalculator.operation.Operation;

import java.util.ArrayList;
import java.util.List;

public class Macro implements Operation {

  public List<Operation> steps = new ArrayList<>();
  private String name;

  @Override
  public int execute(Stack stack) {
    for (Operation step : steps) {
      step.execute(stack);
    }
    return stack.peek();
  }

  public void add(Operation operation) {
    steps.add(operation);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
