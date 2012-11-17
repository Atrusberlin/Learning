package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Macro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationFactory {

  final Plus plus = new Plus();
  final Minus minus = new Minus();
  final Factorial factorial = new Factorial();
  private Times times = new Times();
  private Divide divide = new Divide();
  private Map<String, Macro> macros = new HashMap<>();

  public Operation getOperation(String operator) {
    Operation operation = null;
    switch (operator) {
      case "-":
        operation = minus;
        break;
      case "+":
        operation = plus;
        break;
      case "!":
        operation = factorial;
        break;
      case "*":
        operation = times;
        break;
      case "/":
        operation = divide;
        break;
      default:
        operation = macros.get(operator);
    }
    if (operation == null) {
      throw new UnknownOperationException("unbekannte Operation: " + operator);
    }
    return operation;
  }

  public void addMacro(Macro macro) {
    this.macros.put(macro.getName(), macro);
  }
}