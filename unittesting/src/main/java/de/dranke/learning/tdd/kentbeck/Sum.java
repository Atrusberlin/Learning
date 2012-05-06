package de.dranke.learning.tdd.kentbeck;

/**
 * Created with IntelliJ IDEA.
 * User: Entwickler
 * Date: 26.04.12
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class Sum implements Expression {

  Expression augend;
  Expression addend;

  public Sum(Expression augend, Expression addend) {
    this.augend = augend;
    this.addend = addend;
  }

  @Override
  public Money reduce(Bank bank, String to) {
    int amount = augend.reduce(bank, to).amount
        + addend.reduce(bank, to).amount;
    return new Money(amount, to);
  }

  @Override
  public Expression plus(Expression addend) {
    return new Sum(this, addend);
  }

  @Override
  public Expression times(int multiplier) {
    return new Sum(augend.times(multiplier), addend.times(multiplier));
  }
}