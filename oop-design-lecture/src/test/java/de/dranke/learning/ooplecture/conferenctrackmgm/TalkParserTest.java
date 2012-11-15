package de.dranke.learning.ooplecture.conferenctrackmgm;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static de.dranke.learning.ooplecture.conferenctrackmgm.TestData.TALKS;
import static org.fest.assertions.Assertions.assertThat;

public class TalkParserTest {

  private TalkParser parser;

  @DataProvider
  public Object[][] sessionStrings() {
    return new Object[][] {
        {"", null},
        {null, null},
        {"Writing Fast Tests Against Enterprise Rails 60min", new Talk("Writing Fast Tests Against Enterprise Rails", 60)},
        {"Rails for Python Developers lightning", new Talk("Rails for Python Developers", 5)}
    };
  }

  @BeforeMethod
  protected void setUp() throws Exception {
    parser = new TalkParser();
  }

  @Test(dataProvider = "sessionStrings")
  public void parseAsPair(String sessionString, Talk expectedTalk) {
    // when
    Talk actualTalk = parser.parseAsPair(sessionString);

    // then
    assertThat(actualTalk).isEqualTo(expectedTalk);
  }

  @Test
  public void parseTalks() {
    // when
    List<Talk> result = parser.parseTalks(TALKS);

    // then
    assertThat(result).hasSize(TALKS.size());
    assertThat(result.get(4)).isEqualTo(new Talk("Common Ruby Errors", 45));
  }
}
