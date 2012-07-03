package tasks.advanced;

import tasks.AbstractForLoopTask;
import tasks.ForLoopTask;

import java.util.concurrent.CancellationException;

import static utils.TestUtils.log;

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
