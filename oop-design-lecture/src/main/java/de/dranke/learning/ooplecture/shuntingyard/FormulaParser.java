package de.dranke.learning.ooplecture.shuntingyard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import static de.dranke.learning.ooplecture.shuntingyard.Operator.getOperation;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class FormulaParser {

  private final ArrayList<String> rpn = new ArrayList();
  private final Stack<Operator> operators = new Stack();

  public String[] toRPN(String formula) {
    String[] formulaAsArray = isBlank(formula) ? new String[0] : formula.split(" ");

    for (String item : formulaAsArray) {
      if (Operator.isSupported(item)) {
        proceedOperator(item);
      }
      else {
        rpn.add(item);
      }
    }

    while (!operators.isEmpty() && operators.peek() != null) {
      rpn.add(operators.pop().getSymbol());
    }

    return rpn.toArray(new String[0]);
  }

  private void proceedOperator(String operator) {
    Operator current = getOperation(operator);
    if (operators.isEmpty()) {
      operators.push(current);
    }
    else if (current.comparePreceedenceTo(operators.peek()) > 0) {
      operators.push(current);
    }
    else {
      while (!operators.isEmpty() && current.comparePreceedenceTo(operators.peek()) <= 0) {
        rpn.add(operators.pop().getSymbol());
      }

      operators.push(current);
    }
  }
}