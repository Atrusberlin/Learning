package de.dranke.learning.patterns.templatemethod.abstractsuperclass;

public class InfoMessagePopup extends PopupAbstract {

  private CssResource css;

  public InfoMessagePopup(String irgendWas) {
    super(irgendWas); // fehler durch Aufrufe von templateMethod im super-Konstruktor.
    initPopup();
  }

  private void initPopup() {
    css = new CssResource() {
      @Override
      public String toString() {
        return "InfoMessageCss";
      }
    };
  }

  @Override
  protected CssResource cssResource() {
    return css;
  }

  @Override
  protected void onRenderHeader() {
    System.out.println("Render InfoMessageHeader");
  }

  @Override
  protected void onRenderContent() {
    System.out.println("Render InfoMessageContent");
  }
}
