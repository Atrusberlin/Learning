package de.dranke.learning.ooplecture.shuntingyard;

import java.util.ArrayList;
import java.util.Stack;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class FormulaParser {

//  static {
//    Map<Character, Integer> precedence =  new HashMap() {
//      {'-', 2},
//
//    };
//  }

  public String[] toRPN(String formula) {
    String[] formulaAsArray = isBlank(formula) ? new String[0] : formula.split(" ");
    ArrayList<String> rpn = new ArrayList();
    Stack<String> operators = new Stack();

    for (String item : formulaAsArray) {
      if (item.matches("[0-9]")) {
        rpn.add(item);
      }
      else {
        if (operators.isEmpty() || "+".equals(operators.peek())) {
          rpn.add(item);
        }
        else {
          operators.push(item);
        }
      }

      while (!operators.isEmpty()) {
        rpn.add(operators.pop());
      }
    }
    return rpn.toArray(new String[0]);
  }
}