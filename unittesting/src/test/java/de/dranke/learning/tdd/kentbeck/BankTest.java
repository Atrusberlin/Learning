package de.dranke.learning.tdd.kentbeck;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: Entwickler
 * Date: 26.04.12
 * Time: 21:30
 * To change this template use File | Settings | File Templates.
 */
public class BankTest extends TestCase {

  public void testReduceSum() {
    Bank bank = new Bank();
    Money result = bank.reduce(Money.dollar(1), "USD");
    assertEquals(Money.dollar(1), result);
  }

  public void testReduceMoneyDifferentCurrency() {
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Money result = bank.reduce(Money.franc(2), "USD");
    assertEquals(Money.dollar(1), result);
  }

  public void testIdentityRate() {
    assertEquals(1, new Bank().rate("USD", "USD"));
  }
}
