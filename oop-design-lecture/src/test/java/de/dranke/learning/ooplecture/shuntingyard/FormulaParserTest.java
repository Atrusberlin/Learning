package de.dranke.learning.ooplecture.shuntingyard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class FormulaParserTest {

  private FormulaParser formulaParser;

  @DataProvider
  public Object[][] formula_string_expressions() {
    return new Object[][] {
        {"", new String[0]},
        {null, new String[0]},
        {"4", toStringArray("4")},
        {"4 + 3", toStringArray("4 3 +")},
        {"4 + 3 - 2", toStringArray("4 3 2 + -")},
        {"4 + 3 * 2 + 5", toStringArray("4 3 2 * + 5 +")}
    };
  }

  @BeforeMethod
  protected void setUp() throws Exception {
    formulaParser = new FormulaParser();
  }

  @Test(dataProvider = "formula_string_expressions")
  public void toRPN_returns_correct_Reverse_Polish_Notation(String formulaAsString, String[] expectedRPN) {
    // given

    // when
    String[] actual = formulaParser.toRPN(formulaAsString);

    // then
    assertThat(actual).isEqualTo(expectedRPN);
  }

  private String[] toStringArray(String string) {
    return string.split(" ");
  }
}
