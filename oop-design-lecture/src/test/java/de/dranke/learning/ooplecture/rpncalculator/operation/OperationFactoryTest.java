package de.dranke.learning.ooplecture.rpncalculator.operation;

import de.dranke.learning.ooplecture.rpncalculator.Macro;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class OperationFactoryTest {

  @Test
  public void addMacro() {
    // given
    OperationFactory factory = new OperationFactory();

    // when
    Macro macro = new Macro();
    macro.setName("test");
    factory.addMacro(macro);

    // then
    assertThat(factory.getOperation("test")).isSameAs(macro);
  }

  @Test(expectedExceptions = UnknownOperationException.class)
  public void getUnknownOperation_throws_UnknownOperationexception() {
    // given
    OperationFactory factory = new OperationFactory();

    // when
    factory.getOperation("gibbet nich");

    // then Exception
  }
}
