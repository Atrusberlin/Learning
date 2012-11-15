package de.dranke.learning.ooplecture.conferenctrackmgm;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class SessionTest {

  @Test
  public void remaining_time() {
    // given
    Session session = new Session(120);

    assertThat(session.remainingTime()).isEqualTo(120);
  }

  @Test
  public void remaining_time_with_talks() {
    // given
    Session session = new Session(120);
    session.addTalk(createTalk(90));
    session.addTalk(createTalk(10));

    assertThat(session.remainingTime()).isEqualTo(20);
  }

  @DataProvider
  public Object[][] talksToAdd() {
    return new Object[][] {
        {null, false},
        {createTalk(40), false},
        {createTalk(31), false},
        {createTalk(30), true},
        {createTalk(29), true}
    };
  }

  @Test(dataProvider = "talksToAdd")
  public void add(Talk talk, boolean wasAdded) {
    // given
    Session session = new Session(30);
    // when
    assertThat(session.addTalk(talk)).isEqualTo(wasAdded);
    assertThat(session.getTalks().size()).isEqualTo(wasAdded ? 1 : 0);
  }

  static Talk createTalk(int duration) {
    return new Talk("talk", duration);
  }

  @Test
  public void containsTalk_isTrue() {
    // given
    Session session = new Session(120);
    session.addTalk(new Talk("test 1", 10));

    // when & then
    assertThat(session.containsTalk("test 1")).isTrue();
  }

  @Test
  public void containsTalk_isFalse() {
    // given
    Session session = new Session(120);
    session.addTalk(new Talk("test 1", 10));

    // when & then
    assertThat(session.containsTalk("xyz")).isFalse();
  }
}
