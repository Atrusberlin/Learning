package de.dranke.learning.ooplecture.shuntingyard;

import java.util.HashMap;
import java.util.Map;

class Operator {

  enum Associative {
    LEFT,
    RIGHT;
  }

  final static Operator PLUS = new Operator(2, Associative.LEFT, "+");

  final static Operator MINUS = new Operator(2, Associative.LEFT, "-");
  final static Operator MULTIPLY = new Operator(3, Associative.LEFT, "*");
  final static Operator DIVIDE = new Operator(3, Associative.LEFT, "/");
  final static Operator EXP = new Operator(4, Associative.RIGHT, "^");
  private static Map<String, Operator> supportedOperations = new HashMap();

  static {
    addOperation(PLUS);
    addOperation(MINUS);
    addOperation(MULTIPLY);
    addOperation(DIVIDE);
    addOperation(EXP);
  }

  private static void addOperation(Operator operator) {
    supportedOperations.put(operator.getSymbol(), operator);
  }

  public static boolean isSupported(String operator) {
    return supportedOperations.containsKey(operator);
  }

  public static Operator getOperation(String operator) {
    return supportedOperations.get(operator);
  }

  private int precedence;
  private Associative associative;
  private String symbol;

  private Operator(int precedence, Associative associative, String symbol) {
    this.precedence = precedence;
    this.associative = associative;
    this.symbol = symbol;
  }

  public String getSymbol() {
    return symbol;
  }

  public int comparePreceedenceTo(Operator toCompare) {
    return this.precedence - toCompare.precedence;
  }
}
