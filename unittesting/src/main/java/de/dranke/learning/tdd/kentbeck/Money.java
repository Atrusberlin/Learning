package de.dranke.learning.tdd.kentbeck;

/**
 * Created by IntelliJ IDEA.
 * User: Entwickler
 * Date: 18.04.12
 * Time: 22:28
 * To change this template use File | Settings | File Templates.
 */
public class Money implements Expression {

  protected int amount;
  protected String currency;

  protected Money(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  static Money dollar(int amount) {
    return new Money(amount, "USD");
  }

  public static Money franc(int amount) {
    return new Money(amount, "CHF");
  }

  @Override
  public Expression times(int multiplier) {
    return new Money(amount * multiplier, currency);
  }

  @Override
  public Expression plus(Expression addend) {
    return new Sum(this, addend);
  }

  String currency() {
    return currency;
  }


  @Override
  public String toString() {
    return amount + " " + currency;
  }

  @Override
  public boolean equals(Object obj) {
    Money money = (Money) obj;
    return amount == money.amount && currency.equals(money.currency());
  }

  @Override
  public Money reduce(Bank bank, String to) {
    int rate = bank.rate(currency, to);
    return new Money(amount / rate, to);
  }
}
