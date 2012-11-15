package de.dranke.learning.ooplecture.shuntingyard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class StringParser {

  public String[] toRPN(String s) {
    String[] formulaAsArray = isBlank(s) ? new String[0] : s.split(" ");
    Stack numbers = new Stack();
    Stack operators = new Stack();

    for (String item : formulaAsArray) {
      if (item.matches("[0-9]")) {
        numbers.push(item);
      }
      else {
        operators.push(item);
      }
    }

    return formulaAsArray;
  }
}
