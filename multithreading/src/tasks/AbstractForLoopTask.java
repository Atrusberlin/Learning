package tasks;

import java.math.BigInteger;
import java.util.concurrent.Callable;

import static utils.TestUtils.log;

public abstract class AbstractForLoopTask implements Runnable, Callable<BigInteger> {

  protected int iteration;
  private BigInteger result = new BigInteger("1");
  private int maxIterations = 100_000;

  protected AbstractForLoopTask(int maxIterations) {
    this.maxIterations = maxIterations;
  }

  public void run() {
    call();
  }

  public BigInteger call() {
    return loopMethod();
  }

  private BigInteger loopMethod() {
    printStart();
    executeForLoop();
    printFinished();
    return result;
  }

  private void executeForLoop() {

    for (iteration = 1; iteration < maxIterations; iteration++) {
      heavyCalculation();
      checkThreadInterruption();
    }
  }

  protected abstract void checkThreadInterruption();

  private void printFinished() {
    log(this + " ...finished");
  }

  private void printStart() {
    log(this + " starts ...");
  }

  private void heavyCalculation() {
    result = result.multiply(BigInteger.valueOf((long) iteration));
  }

  public int getIteration() {
    return iteration;
  }
}
