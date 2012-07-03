package de.hypoport.jop.multithreading.tasks.advanced;

import de.hypoport.jop.multithreading.tasks.AbstractForLoopTask;

import java.util.concurrent.CancellationException;

import static de.hypoport.jop.multithreading.utils.TestUtils.log;

public class InterruptableForLoopTask extends AbstractForLoopTask {

  public InterruptableForLoopTask(int maxIterations) {
    super(maxIterations);
  }

  protected void checkThreadInterruption() {
    if (Thread.interrupted()) {
      log("Thread is interrupted " + iteration);
      throw new CancellationException("Thread is interrupted.");
    }
  }
}
