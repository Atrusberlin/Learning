package tests;

import org.junit.Before;
import org.junit.Test;
import tasks.AbstractForLoopTask;
import tasks.ForLoopTask;
import tasks.SleepTask;
import tasks.advanced.InterruptableForLoopTask;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utils.TestUtils.log;
import static utils.TestUtils.sleep;

public class StopTasksTests {

  private ForLoopTask forLoopTask;
  private ExecutorService executorService;
  private SleepTask sleepTask;
  private InterruptableForLoopTask interruptableForLoopTask;

  @Before
  public void init() {
    executorService = Executors.newSingleThreadExecutor();
    forLoopTask = new ForLoopTask(100_000);
    interruptableForLoopTask = new InterruptableForLoopTask(100_000);
    sleepTask = new SleepTask();
  }

  @Test
  public void stopForLoop() throws InterruptedException {
    executeAndShutdownForLoopTask(forLoopTask);
  }

  @Test
  public void stopInterruptableForLoop() throws InterruptedException {
    executeAndShutdownForLoopTask(interruptableForLoopTask);
  }

  @Test
  public void stopSleepTask() throws InterruptedException {
    executorService.execute(sleepTask);
    List<Runnable> unstartedTasks = executorService.shutdownNow();
  }

  private void executeAndShutdownForLoopTask(AbstractForLoopTask loopTask)
      throws InterruptedException {
    executorService.execute(loopTask);
    sleep(1000);
    List<Runnable> runnableList = executorService.shutdownNow();

    log("runnableList.size(): " + runnableList.size());
    log("Iteration: " + loopTask.getIteration());
    sleep(2000);
    log("Iteration: " + loopTask.getIteration());
  }
}