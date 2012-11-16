package de.dranke.learning.ooplecture.shuntingyard;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static de.dranke.learning.ooplecture.shuntingyard.Operator.DIVIDE;
import static de.dranke.learning.ooplecture.shuntingyard.Operator.EXP;
import static de.dranke.learning.ooplecture.shuntingyard.Operator.MINUS;
import static de.dranke.learning.ooplecture.shuntingyard.Operator.MULTIPLY;
import static de.dranke.learning.ooplecture.shuntingyard.Operator.PLUS;
import static org.fest.assertions.Assertions.assertThat;

public class OperatorTest {

  @DataProvider
  public Object[][] operators() {
    return new Object[][] {
        {PLUS, MINUS, 0},
        {PLUS, MULTIPLY, -1},
        {PLUS, DIVIDE, -1},
        {PLUS, EXP, -2},
        {MULTIPLY, MINUS, 1},
        {MULTIPLY, PLUS, 1},
        {MULTIPLY, DIVIDE, 0},
        {MULTIPLY, EXP, -1}
    };
  }

  @Test(dataProvider = "operators")
  public void testComparePreceedenceTo(Operator operator, Operator toCompare, int expectedDifference) {

    assertThat(operator.comparePreceedenceTo(toCompare)).isEqualTo(expectedDifference);
  }
}
