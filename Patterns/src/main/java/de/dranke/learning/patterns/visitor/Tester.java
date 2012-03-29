package de.dranke.learning.patterns.visitor;

/** Created by IntelliJ IDEA. User: daniel.ranke Date: 08.03.12 Time: 13:20 To change this template use File | Settings | File Templates. */
public class Tester implements Visitor {

  public static void main(String args[]) {
    Tester tester = new Tester();

    Darlehen darlehenKfw = new KfwDarlehen();
    Darlehen darlehenAnnu = new AnuitaetenDarlehen();

    // tester.displayDarlehen(darlehen); geht nicht, da nicht eindeutig
    tester.displayDarlehen(new KfwDarlehen()); // geht da der konkrete Typ verwendet wird
    darlehenKfw.accept(tester);
    darlehenAnnu.accept(tester);
  }

  public void displayDarlehen(AnuitaetenDarlehen ad) {
    System.out.println("Anuitätendarlehen.");
  }

  public void displayDarlehen(KfwDarlehen kd) {
    System.out.println("KFW Darlehen.");
  }
}
