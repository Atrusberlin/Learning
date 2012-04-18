package de.dranke.learning.tdd.kentbeck;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Entwickler
 * Date: 17.04.12
 * Time: 21:26
 * To change this template use File | Settings | File Templates.
 */
public class DollarTest {
  
  @Test
  public void testMultiplications() {
    Dollar five = new Dollar(5);
    assertEquals(new Dollar(10), five.times(2));
    assertEquals(new Dollar(15), five.times(3));
  }

  @Test
  public void testEquality() {
    assertTrue(new Dollar(5).equals(new Dollar(5)));
    assertEquals(new Dollar(5), new Dollar(5));
    assertFalse(new Dollar(5).equals(new Dollar(6)));
  }
}
