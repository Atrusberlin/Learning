package de.dranke.learning.patterns.templatemethod.abstractsuperclass;

/**
 * User: Daniel
 * Date: 16.09.12
 */
public abstract class Popup {

  public void show() {
    System.out.println("Show popup.");
  }

  public void hide() {
    System.out.println("Hide popup.");
  }

  protected abstract CssResource cssResource();
  protected abstract void onRenderHeader();
  protected abstract void onRenderContents();
}
