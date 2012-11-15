package de.dranke.learning.principles.lsp;

public class Rectangle {

  private double heigth;

  private double width;

  public Rectangle(double heigth, double width) {
    this.heigth = heigth;
    this.width = width;
  }

  public double getHeigth() {
    return heigth;
  }

  public void setHeight(double heigth) {
    this.heigth = heigth;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double calculateArea() {
    return width * heigth;
  }
}
