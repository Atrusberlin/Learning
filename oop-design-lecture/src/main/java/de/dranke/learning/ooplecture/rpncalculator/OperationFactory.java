package de.dranke.learning.ooplecture.rpncalculator;

public class OperationFactory {

  final Plus plus = new Plus();
  final Minus minus = new Minus();
  final Factorial factorial = new Factorial();
  private Multiply multiply = new Multiply();
  private Divide divide = new Divide();

  Operation getOperation(String operator) {
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
        operation = multiply;
        break;
      case "/":
        operation = divide;
        break;
    }
    return operation;
  }
}