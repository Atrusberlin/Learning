package de.dranke.learning.tdd.kentbeck;

import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: Entwickler
 * Date: 06.05.12
 * Time: 20:33
 * To change this template use File | Settings | File Templates.
 */
public class SumTest extends TestCase {
  public void testSumPlusMoney() throws Exception {
    Expression fiveBucks = Money.dollar(5);
    Expression tenFrancs = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
    Money result = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(15), result);
  }

  public void testSumTimes() {
    Expression fiveBucks = Money.dollar(5);
    Expression tenFranc = Money.franc(10);
    Bank bank = new Bank();
    bank.addRate("CHF", "USD", 2);
    Expression sum = new Sum(fiveBucks, tenFranc).times(2);
    Money result = bank.reduce(sum, "USD");
    assertEquals(Money.dollar(20), result);
  }


}
