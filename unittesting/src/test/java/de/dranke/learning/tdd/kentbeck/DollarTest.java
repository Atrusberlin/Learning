package de.dranke.learning.tdd.kentbeck;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

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
    Dollar product = five.times(2);
    assertEquals(10, product.amount);
    product = five.times(3);
    assertEquals(15, product.amount);
  }
}
