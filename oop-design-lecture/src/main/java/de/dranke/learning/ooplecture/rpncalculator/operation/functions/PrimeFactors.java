package de.dranke.learning.ooplecture.rpncalculator.operation.functions;

import de.dranke.learning.ooplecture.rpncalculator.Stack;
import de.dranke.learning.ooplecture.rpncalculator.operation.Operation;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import static org.apache.commons.lang3.ArrayUtils.EMPTY_INT_ARRAY;

public class PrimeFactors implements Operation {

  @Override
  public int execute(Stack stack) {
    int input = stack.pop();
    if (input > 1) {
      for (int i : zerlegeInternal(input)) {
        stack.push(i);
      }
    }
    return stack.peek();
  }

  private int[] zerlegeInternal(int input) {
    int[] result = EMPTY_INT_ARRAY;
    if (input == 1) { return result; }

    int factor = getPrimeFactor(input);
    if (factor > 0) {
      int[] ints = zerlegeInternal(input / factor);
      result = ArrayUtils.add(ints, factor);
    }
    return result;
  }

  private int getPrimeFactor(int input) {
    for (int primeNumber = 2; primeNumber < input; primeNumber++) {
      if (input % primeNumber == 0) {
        return primeNumber;
      }
    }
    return input;
  }
}
