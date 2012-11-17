package de.dranke.learning.ooplecture.rpncalculator.operation;

public class UnknownOperationException extends RuntimeException {

  public UnknownOperationException(String errorMessage) {
    super(errorMessage);
  }
}
