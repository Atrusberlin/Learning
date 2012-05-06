package de.dranke.learning.tdd.kentbeck;

import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: Entwickler
 * Date: 25.04.12
 * Time: 23:23
 * To change this template use File | Settings | File Templates.
 */
public class Bank {

  private Hashtable rates = new Hashtable();

  public Money reduce(Expression source, String to) {
    return source.reduce(this, to);
  }

  public void addRate(String from, String to, int rate) {
    rates.put(new Pair(from, to), new Integer(rate));
  }

  int rate(String from, String to) {
    if (from.equals(to)) return 1;
    Integer rate = (Integer) rates.get(new Pair(from, to));
    return rate.intValue();
  }

}
