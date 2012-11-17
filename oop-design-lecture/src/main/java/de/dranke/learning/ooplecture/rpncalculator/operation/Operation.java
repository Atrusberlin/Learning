package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Stack;

public interface Operation {

  int execute(Stack stack);
}
