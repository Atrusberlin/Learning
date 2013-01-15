package de.dranke.learning.kata.args.training01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ArgsParserTest {

  private Schema testSchema;
  private ArgsParser parser;

  @BeforeMethod
  public void setUp() throws Exception {
    testSchema = new TestSchema();
    parser = new ArgsParser(testSchema);
  }

  @Test
  public void initialize_with_schema() {
    // given

    // when
    ArgsParser parser = new ArgsParser(testSchema);

    // then
    assertThat(parser.isInitialized()).isTrue();
  }

  @DataProvider
  public Object[][] arguments() {
    return new Object[][]{
        {"-l", 'l'},
        {"-l -p 8080", 'p'},
        {"-l -p 8080 -d /usr/logs ", 'd'},
    };
  }

  @Test(dataProvider = "arguments")
  public void argument_is_identified_by_leading_minus(String args, char argFlag) {

    // when
    boolean result = parser.containsArgument(args, argFlag);

    // then
    assertThat(result).isTrue();
  }

  @Test
  public void argument_is_not_identified__if_leading_minus_is_missing() {
    // given
    String args = "l";

    // when
    boolean result = parser.containsArgument(args, 'l');

    // then
    assertThat(result).isFalse();
  }

  @Test
  public void parse_allows_schema_defined_flags_only() {
    // given

    // when

    // then
  }
}
