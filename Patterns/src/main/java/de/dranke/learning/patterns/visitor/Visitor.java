package de.dranke.learning.patterns.visitor;

/** Created by IntelliJ IDEA. User: daniel.ranke Date: 08.03.12 Time: 13:34 To change this template use File | Settings | File Templates. */
public interface Visitor {

  void displayDarlehen(AnuitaetenDarlehen anuitaetenDarlehen);

  void displayDarlehen(KfwDarlehen kfwDarlehen);
}
