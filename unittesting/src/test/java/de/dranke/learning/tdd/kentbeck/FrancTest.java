package de.dranke.learning.tdd.kentbeck;

import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * User: Entwickler
 * Date: 18.04.12
 * Time: 22:13
 * To change this template use File | Settings | File Templates.
 */
public class FrancTest {
  
  @Test
  public void testFrancMultiplication() {
    Franc five = new Franc(5);
    assertEquals(new Franc(10), five.times(2));
    assertEquals(new Franc(15), five.times(3));
  }
}
