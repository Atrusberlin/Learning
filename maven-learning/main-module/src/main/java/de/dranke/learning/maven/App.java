package de.dranke.learning.maven;

import de.dranke.learning.maven.componentone.api.DemoServiceOne;
import de.dranke.learning.maven.componentone.api.model.ModelOne;

/**
 * Hello world!
 */
public class App {

  private DemoServiceOne serviceOne;

  public static void main(String[] args) {
    System.out.println("Hello World!");
  }

  private void ComponentOneInit() {
    ModelOne modelOne = serviceOne.get(0);
    System.out.println(modelOne.getTitle());
  }
}
