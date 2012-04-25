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
  public void testDollarMultiplications() {
    Dollar five = new Dollar(5, "USD");
    assertEquals(new Dollar(10, "USD"), five.times(2));
    assertEquals(new Dollar(15, "USD"), five.times(3));
  }


}
