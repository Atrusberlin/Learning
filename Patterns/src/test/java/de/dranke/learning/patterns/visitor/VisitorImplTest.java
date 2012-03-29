package de.dranke.learning.patterns.visitor;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class VisitorImplTest {

  @Test
  public void es_wird_die_DisplayMethode_des_jeweiligen_Darlehens_aufgerufen() {
    // given
    Darlehen annuDarlehen = new AnuitaetenDarlehen();
    Darlehen kfwDarlehen = new KfwDarlehen();
    VisitorImpl visitor = new VisitorImpl();

    // when & then
    // der nachfolgende Aufruf geht eben nicht, da der Typ zu unspezifisch ist und vorher
    // gecastet werden müsste.
    //visitor.displayDarlehen(annuDarlehen);
    // visitor würde in diesem Beispiel eine Implementierung sein, die mit den verschiedene Darlehen arbeitet.
    assertThat(annuDarlehen.display(visitor).equals(Visitor.ANNU));
    assertThat(kfwDarlehen.display(visitor).equalsIgnoreCase(Visitor.KFW));
  }
}
