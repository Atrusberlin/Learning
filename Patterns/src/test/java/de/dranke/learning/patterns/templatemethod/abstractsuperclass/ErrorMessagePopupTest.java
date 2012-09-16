package de.dranke.learning.patterns.templatemethod.abstractsuperclass;

import org.testng.annotations.Test;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

/**
 * User: Daniel
 * Date: 16.09.12
 */
public class ErrorMessagePopupTest {


  @Test
  public void show_calls_all_overridden_methods() {
    // given
    ErrorMessagePopup popup = spy(new ErrorMessagePopup());

    // when
    popup.show();

    // then
    verify(popup).cssResource();
    verify(popup).onRenderHeader();
    verify(popup).onRenderContents();

  }
}
