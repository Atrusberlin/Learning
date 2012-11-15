package de.dranke.learning.ooplecture.conferenctrackmgm;

class Talk {

  private String title;
  private int length;

  public Talk(String title, int length) {
    this.title = title;
    this.length = length;
  }

  public String getTitle() {
    return title;
  }

  public int getDuration() {
    return length;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }

    Talk talk = (Talk) o;

    if (length != talk.length) { return false; }
    if (title != null ? !title.equals(talk.title) : talk.title != null) { return false; }

    return true;
  }

  @Override
  public int hashCode() {
    int result = title != null ? title.hashCode() : 0;
    result = 31 * result + length;
    return result;
  }
}
