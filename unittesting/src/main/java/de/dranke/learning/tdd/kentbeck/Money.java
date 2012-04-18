package de.dranke.learning.tdd.kentbeck;

/**
 * Created by IntelliJ IDEA.
 * User: Entwickler
 * Date: 18.04.12
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public class Money {

  protected int amount;

  @Override
  public boolean equals(Object obj) {
    Money money = (Money) obj;
    return amount == money.amount && getClass().equals(money.getClass());
  }
}
