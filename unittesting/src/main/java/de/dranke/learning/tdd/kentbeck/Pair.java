package de.dranke.learning.tdd.kentbeck;

/**
 * Created by IntelliJ IDEA.
 * User: Entwickler
 * Date: 06.05.12
 * Time: 07:22
 * To change this template use File | Settings | File Templates.
 */
public class Pair {

  private String from;
  private String to;

  public Pair(String from, String to) {
    this.from = from;
    this.to = to;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pair pair = (Pair) o;

    if (!from.equals(pair.from)) return false;
    if (!to.equals(pair.to)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = from.hashCode();
    result = 31 * result + to.hashCode();
    return result;
  }
}
