package de.dranke.learning.tdd.kentbeck;

/**
 * Created by IntelliJ IDEA.
 * User: Entwickler
 * Date: 17.04.12
 * Time: 21:52
 * To change this template use File | Settings | File Templates.
 */
public class Franc extends Money {

  Franc(int amount) {
    this.amount = amount;
  }

  Money times(int multiplier) {
    return new Franc(amount * multiplier);
  }

}
