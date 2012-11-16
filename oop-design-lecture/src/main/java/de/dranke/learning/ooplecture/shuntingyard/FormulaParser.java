package de.dranke.learning.ooplecture.shuntingyard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class FormulaParser {

  private final ArrayList<String> rpn = new ArrayList();
  private final Stack<Operator> operators = new Stack();

  final static HashMap<Character, Operator> OPERATIONS = new HashMap() {
    {
      put("-", Operator.MINUS);
      put("+", Operator.PLUS);
      put("*", Operator.MULTIPLY);
      put("/", Operator.DIVIDE);
      put("^", Operator.EXP);
    }
  };

  public String[] toRPN(String formula) {
    String[] formulaAsArray = isBlank(formula) ? new String[0] : formula.split(" ");

    for (String item : formulaAsArray) {
      if (item.matches("[0-9]")) {
        rpn.add(item);
      }
      else {
        proceedOperator(item);
      }
    }

    while (!operators.isEmpty() && operators.peek() != null) {
      rpn.add(operators.pop().getSymbol());
    }

    return rpn.toArray(new String[0]);
  }

  private void proceedOperator(String item) {
    Operator itemOperator = OPERATIONS.get(item);
    if (operators.isEmpty()) {
      operators.push(OPERATIONS.get(item));
    }
    else if (itemOperator.comparePreceedenceTo(operators.peek()) > 0) {
      rpn.add(item);
    }
    else {
      operators.push(OPERATIONS.get(item));
    }
  }
}