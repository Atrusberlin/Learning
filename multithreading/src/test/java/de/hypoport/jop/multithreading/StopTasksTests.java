package de.hypoport.jop.multithreading;

import de.hypoport.jop.multithreading.tasks.AbstractForLoopTask;
import de.hypoport.jop.multithreading.tasks.ForLoopTask;
import de.hypoport.jop.multithreading.tasks.SleepTask;
import de.hypoport.jop.multithreading.tasks.advanced.InterruptableForLoopTask;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static de.hypoport.jop.multithreading.utils.TestUtils.log;
import static de.hypoport.jop.multithreading.utils.TestUtils.sleep;

public class StopTasksTests {

  private ForLoopTask forLoopTask;
  private ExecutorService executorService;
  private SleepTask sleepTask;
  private InterruptableForLoopTask interruptableForLoopTask;

  @BeforeMethod
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