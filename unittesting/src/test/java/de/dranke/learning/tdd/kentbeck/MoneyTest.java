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
    assertTrue(new Dollar(5).equals(new Dollar(5)));
    assertFalse(new Dollar(5).equals(new Dollar(6)));
    assertTrue(new Franc(5).equals(new Franc(5)));
    assertFalse(new Franc(5).equals(new Franc(6)));
    assertFalse(new Franc(5).equals(new Dollar(5)));
  }
}
