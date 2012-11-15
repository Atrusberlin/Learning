package de.dranke.learning.principles.lsp;

public class Square extends Rectangle {

  public Square(double size) {
    super(size, size);
  }

  @Override
  public void setHeight(double heigth) {
    super.setHeight(heigth);
    super.setWidth(heigth);
  }

  @Override
  public void setWidth(double width) {
    super.setWidth(width);
    super.setHeight(width);
  }
}
