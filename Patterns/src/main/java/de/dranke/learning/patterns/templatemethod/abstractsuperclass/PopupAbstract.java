package de.dranke.learning.patterns.templatemethod.abstractsuperclass;

/** User: Daniel Date: 16.09.12 */
public abstract class PopupAbstract {

  private String irgendWas;

  protected PopupAbstract() {
  }

  protected PopupAbstract(String irgendWas) {
    this.irgendWas = irgendWas;
    // Der Aufruf der TemplateMethod im Konstruktor kann zu Fehlern führen, da in den abgeleiteten Klassen ggf. noch nicht alle Member initialisiert wurden.
    show();
  }

  public void show() {
    System.out.println("loading css resources: " + cssResource().toString());
    onRenderHeader();
    onRenderContent();
    System.out.println("Show popup.");
  }

  public void hide() {
    System.out.println("Hide popup.");
  }

  protected abstract CssResource cssResource();

  protected abstract void onRenderHeader();

  protected abstract void onRenderContent();
}
