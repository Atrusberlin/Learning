package de.dranke.learning.tdd.kentbeck;

import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: Entwickler
 * Date: 18.04.12
 * Time: 22:34
 * To change this template use File | Settings | File Templates.
 */
public class MoneyTest extends TestCase {
  public void testEquality() throws Exception {
    assertTrue(Money.dollar(5).equals(Money.dollar(5)));
    assertFalse(Money.dollar(5).equals(Money.dollar(6)));
    assertTrue(Money.franc(5).equals(Money.franc(5)));
    assertFalse(Money.franc(5).equals(Money.franc(6)));
    assertFalse(Money.franc(5).equals(Money.dollar(5)));
  }

  public void testMultiplication() {
    Money five = Money.dollar(5);
    assertEquals(Money.dollar(10), five.times(2));
    assertEquals(Money.dollar(15), five.times(3));
  }

  public void testCurrency() {
    assertEquals("USD", Money.dollar(1).currency());
    assertEquals("CHF", Money.franc(1).currency());
  }

  public void testDifferentClassEquality() {
    assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
  }
}
