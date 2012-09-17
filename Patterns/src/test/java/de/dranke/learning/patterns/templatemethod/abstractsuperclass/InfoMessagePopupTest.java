package de.dranke.learning.patterns.templatemethod.abstractsuperclass;

import org.testng.annotations.Test;

public class InfoMessagePopupTest {

  @Test(expectedExceptions = NullPointerException.class)
  public void show_loest_eine_Exception_aus_durch_den_Contructor_der_Implementierung() {
    // when
    InfoMessagePopup popup = new InfoMessagePopup("");

    // then exception

  }
}
