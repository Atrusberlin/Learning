package de.dranke.learning.ooplecture.rpncalculator;

public class Multiply extends OperationTwoNumbers {

  @Override
  protected int calculate(int left, int right) {
    return left * right;
  }
}
