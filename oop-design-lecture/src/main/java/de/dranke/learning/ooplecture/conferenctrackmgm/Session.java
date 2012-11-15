package de.dranke.learning.ooplecture.conferenctrackmgm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class Session {

  private List<Talk> talks = new ArrayList();
  private Integer duration;

  public Session(Integer duration) {
    this.duration = duration;
  }

  public Collection<Talk> getTalks() {
    return new ArrayList(talks);
  }

  public boolean addTalk(Talk talk) {
    if (talk != null && talk.getDuration() <= remainingTime()) {
      talks.add(talk);
      return true;
    }
    return false;
  }

  public Integer getDuration() {
    return duration;
  }

  public Talk getTalk(int position) {
    return talks.get(position);
  }

  public Integer remainingTime() {
    Integer remaininigTime = duration;
    for (Talk talk : talks) {
      remaininigTime -= talk.getDuration();
    }
    return remaininigTime;
  }

  public boolean containsTalk(String talkTitle) {
    for (Talk talk : talks) {
      if (talk.getTitle().toLowerCase().equals(talkTitle.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
}
