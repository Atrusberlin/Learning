package de.dranke.learning.ooplecture.shuntingyard;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.fest.assertions.Assertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class FormulaParserTest {

  private FormulaParser formulaParser;

  @DataProvider
  public Object[][] formula_string_expressions() {
    return new Object[][] {
        {"", ""},
        {null, ""},
        {"4", "4"},
        {"4 + 3", "4 3 +"},
        {"4 + 3 - 2", "4 3 + 2 -"},
        {"4 + 3 * 2 + 5", "4 3 2 * + 5 +"},
        {"4 + 3 * 2 + 5 / 1", "4 3 2 * + 5 1 / +"}
    };
  }

  @BeforeMethod
  protected void setUp() throws Exception {
    formulaParser = new FormulaParser();
  }

  @Test(dataProvider = "formula_string_expressions")
  public void toRPN_returns_correct_Reverse_Polish_Notation(String formulaAsString, String expectedRPN) {
    // given

    // when
    String[] actual = formulaParser.toRPN(formulaAsString);

    // then
    assertThat(actual).isEqualTo(toStringArray(expectedRPN));
  }

  // ToDo [DRa, 16.11.12 )]: bad
  private String[] toStringArray(String string) {
    return isBlank(string) ? new String[0] : string.split(" ");
  }
}
