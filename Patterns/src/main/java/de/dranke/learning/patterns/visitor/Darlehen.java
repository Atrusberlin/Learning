package de.dranke.learning.patterns.visitor;

/** Created by IntelliJ IDEA. User: daniel.ranke Date: 08.03.12 Time: 13:19 To change this template use File | Settings | File Templates. */
public abstract class Darlehen {

  abstract void accept(Visitor visitor);
}
