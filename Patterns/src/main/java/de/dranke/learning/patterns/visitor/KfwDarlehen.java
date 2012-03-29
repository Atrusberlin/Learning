package de.dranke.learning.patterns.visitor;

/** Created by IntelliJ IDEA. User: daniel.ranke Date: 08.03.12 Time: 13:20 To change this template use File | Settings | File Templates. */
public class KfwDarlehen extends Darlehen {

  @Override
  String display(Visitor visitor) {
    return visitor.displayDarlehen(this);
  }
}
