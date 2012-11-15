package de.dranke.learning.ooplecture.conferenctrackmgm;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static de.dranke.learning.ooplecture.conferenctrackmgm.SessionTest.createTalk;
import static org.fest.assertions.ArrayInspection.toList;
import static org.fest.assertions.Assertions.assertThat;

public class SchedulerTest {

  private Scheduler scheduler;
  static final List<Talk> talks = new TalkParser().parseTalks(TestData.TALKS);

  @BeforeMethod
  protected void setUp() throws Exception {
    scheduler = new Scheduler();
  }

  @Test
  public void eine_session_wird_gefuellt() {
    // given
    int sessionlength = 180;

    // when
    Session session = scheduler.fillSession(talks, sessionlength);

    // then
    assertThat(session.getTalks()).hasSize(4);
    assertThat(session.containsTalk("Writing Fast Tests Against Enterprise Rails")).isTrue();
    assertThat(session.containsTalk("Overdoing it in Python")).isTrue();
    assertThat(session.containsTalk("Lua for the Masses")).isTrue();
    assertThat(session.containsTalk("Ruby Errors from Mismatched Gem Versions")).isTrue();
  }

  @Test
  public void eine_Session_ist_genau_180_Minuten_lang() {
    // given
    List<Talk> talks = new ArrayList();
    talks.add(new Talk("1", 120));
    talks.add(new Talk("2", 120));
    talks.add(new Talk("3", 60));
    talks.add(new Talk("4", 120));

    // when
    Session session = scheduler.fillSession(talks, 180);

    // then
    assertThat(session.getTalks()).hasSize(2);
    assertThat(session.containsTalk("1")).isTrue();
    assertThat(session.containsTalk("3")).isTrue();
  }
}
