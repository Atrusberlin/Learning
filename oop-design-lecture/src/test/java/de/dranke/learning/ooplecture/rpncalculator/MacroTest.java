package de.dranke.learning.ooplecture.rpncalculator;

import de.dranke.learning.ooplecture.rpncalculator.operation.Operation;
import org.mockito.InOrder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class MacroTest {

  private Macro macro;
  private Stack stack;

  @BeforeMethod
  protected void setUp() throws Exception {
    macro = new Macro();
    stack = new Stack();
  }

  @Test
  public void creating_an_macro() {
    // when
    macro.add(mock(Operation.class));
    macro.add(mock(Operation.class));

    // then
    assertThat(macro.steps).hasSize(2);
  }

  @Test
  public void execute() {
    // given
    Operation operation1 = mock(Operation.class);
    macro.add(operation1);
    Operation operation2 = mock(Operation.class);
    macro.add(operation2);

    InOrder inOrder = inOrder(operation1, operation2);

    // when
    macro.execute(stack);
    // then
    inOrder.verify(operation1).execute(stack);
    inOrder.verify(operation2).execute(stack);
  }
}
