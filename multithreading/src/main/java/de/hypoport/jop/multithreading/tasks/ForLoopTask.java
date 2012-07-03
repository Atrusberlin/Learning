package de.hypoport.jop.multithreading.tasks;

import static de.hypoport.jop.multithreading.utils.TestUtils.log;

public class ForLoopTask extends AbstractForLoopTask {

  public ForLoopTask(int maxIterations) {
    super(maxIterations);
  }

  @Override
  protected void checkThreadInterruption() {
    if (Thread.interrupted()) {
      log("Thread is interrupted " + iteration);
    }
  }
}
