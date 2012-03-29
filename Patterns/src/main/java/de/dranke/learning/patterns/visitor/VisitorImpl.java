package de.dranke.learning.patterns.visitor;

public class VisitorImpl implements Visitor {

  public VisitorImpl() {
  }

  public String displayDarlehen(AnuitaetenDarlehen ad) {
    return Visitor.ANNU;
  }

  public String displayDarlehen(KfwDarlehen kd) {
    return Visitor.KFW;
  }
}