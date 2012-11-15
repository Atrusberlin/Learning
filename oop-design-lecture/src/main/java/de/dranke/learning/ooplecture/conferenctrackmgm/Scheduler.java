package de.dranke.learning.ooplecture.conferenctrackmgm;

class Scheduler {

  public Session fillSession(Iterable<Talk> talks, int sessionlength) {
    Session session = new Session(sessionlength);

    for (Talk talk : talks) {
      if (session.remainingTime() >= talk.getDuration()) { session.addTalk(talk); }
    }

    return session;
  }
}
