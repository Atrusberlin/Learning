package de.dranke.learning.ooplecture.shuntingyard;

class Operator {

  enum Associative {
    LEFT,
    RIGHT
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

  final static Operator PLUS = new Operator(2, Associative.LEFT, "+");
  final static Operator MINUS = new Operator(2, Associative.LEFT, "-");
  final static Operator MULTIPLY = new Operator(3, Associative.LEFT, "*");
  final static Operator DIVIDE = new Operator(3, Associative.LEFT, "/");
  final static Operator EXP = new Operator(4, Associative.RIGHT, "^");

  public int comparePreceedenceTo(Operator toCompare) {
    return this.precedence - toCompare.precedence;
  }
}
