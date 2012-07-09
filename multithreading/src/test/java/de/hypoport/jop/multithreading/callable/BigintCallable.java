package de.hypoport.jop.multithreading.callable;

import de.hypoport.jop.multithreading.tasks.AbstractForLoopTask;

import static de.hypoport.jop.multithreading.utils.TestUtils.log;

class BigintCallable extends AbstractForLoopTask {

  BigintCallable(int maxIterations) {
    super(maxIterations);
  }

  @Override
  protected void checkThreadInterruption() {
    if (Thread.currentThread().isInterrupted()) {
      log("Task wurde unterbrochen, nach " + getIteration() + " Iterationen.");
      throw new RuntimeException("Task beendet.");
    }
  }
}
