package tasks;

import static utils.TestUtils.log;
import static utils.TestUtils.sleep;

public class SleepTask implements Runnable {

  public void run() {
    sleepMethod();
  }

  private void sleepMethod() {
    try {
      log(this + " starts ...");
      sleep(30_000);
      log(this + " ...finished");
    }
    catch (InterruptedException e) {
      log(e);
    }
  }
}
