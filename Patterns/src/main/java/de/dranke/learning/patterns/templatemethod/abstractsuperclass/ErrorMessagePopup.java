package de.dranke.learning.patterns.templatemethod.abstractsuperclass;

/**
 * User: Daniel
 * Date: 16.09.12
 */
public class ErrorMessagePopup extends Popup {

  @Override
  protected CssResource cssResource() {
    return new CssResource() {
      @Override
      public String toString() {
        return "ErrorMessageCss";
      }
    };
  }

  @Override
  protected void onRenderHeader() {
    System.out.println("Render ErrorMessageHeader.");
  }

  @Override
  protected void onRenderContents() {
    System.out.println("Render ErrorMessageContent");
  }
}
