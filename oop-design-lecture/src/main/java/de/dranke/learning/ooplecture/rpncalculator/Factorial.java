package de.dranke.learning.ooplecture.rpncalculator;

public class Factorial extends OperationOneNumber {

  @Override
  protected int calculate(int number) {
    return factorial(number);
  }

  private int factorial(int number) {
    return number > 1 ? number * factorial(--number) : number;
  }
}
