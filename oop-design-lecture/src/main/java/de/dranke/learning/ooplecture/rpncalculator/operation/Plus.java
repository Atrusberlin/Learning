package de.dranke.learning.ooplecture.rpncalculator.operation;

class Plus extends OperationTwoNumbers {

  @Override
  protected int calculate(int left, int right) {
    return left + right;
  }
}