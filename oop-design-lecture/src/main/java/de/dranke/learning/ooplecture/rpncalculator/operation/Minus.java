package de.dranke.learning.ooplecture.rpncalculator.operation;

class Minus extends OperationTwoNumbers {

  @Override
  protected int calculate(int left, int right) {
    return left - right;
  }
}