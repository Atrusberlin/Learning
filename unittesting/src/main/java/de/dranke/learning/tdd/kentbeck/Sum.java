package de.dranke.learning.tdd.kentbeck;

/**
 * Created with IntelliJ IDEA.
 * User: Entwickler
 * Date: 26.04.12
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class Sum implements Expression {

  Money augend;
  Money addend;

  public Sum(Money augend, Money addend) {
    this.augend = augend;
    this.addend = addend;
  }

  @Override
  public Money reduce(String to) {
    int amount = augend.amount + addend.amount;
    return new Money(amount, to);
  }
}
