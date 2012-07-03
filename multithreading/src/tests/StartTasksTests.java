package tests;

import org.junit.Test;
import tasks.ForLoopTask;
import tasks.SleepTask;
import tasks.advanced.InterruptableForLoopTask;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static utils.TestUtils.log;
import static utils.TestUtils.sleep;

public class StartTasksTests {

  private ForLoopTask forLoopTask;
  private ForLoopTask forLoopTask2;

  @Test
  public void testNewThread() throws InterruptedException {
    ForLoopTask forLoopTask = new ForLoopTask(1000);
    Thread thread = new Thread(forLoopTask);
    thread.start();
    sleep(1000);
    log(forLoopTask.getIteration());
    sleep(1000);
    log(forLoopTask.getIteration());
  }

  @Test
  public void testFixedExecutor() throws InterruptedException {
    forLoopTask = new ForLoopTask(100_000);
    forLoopTask2 = new ForLoopTask(1_000);

    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

    fixedThreadPool.execute(forLoopTask);
    fixedThreadPool.execute(forLoopTask2);

    log("Executors are executing...");
    sleep(1_000);
    log("forLoopTask.getIteration(): " + forLoopTask.getIteration());
    sleep(30_000);
    log("interruptableForLoopTask.getIteration(): " + forLoopTask2.getIteration());
  }

  @Test
  public void testThreadPoolExecutor() throws InterruptedException, ExecutionException {
    forLoopTask = new ForLoopTask(100_000);
    ForLoopTask forLoopTask2 = new ForLoopTask(1_000);

    int coreSizeDesThreadPools = 1;
    int maxPoolSize = 10;
    long keepAliveTime = 100_000;
    BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<Runnable>(5);
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSizeDesThreadPools,
                                                                   maxPoolSize,
                                                                   keepAliveTime,
                                                                   TimeUnit.SECONDS,
                                                                   taskQueue,
                                                                   Executors.defaultThreadFactory()) {
      @Override
      protected void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        log("Start thread: " + thread.getName() + thread.getId() + " with task" + runnable + " Queue: " + getQueue().size());
      }

      @Override
      protected void afterExecute(Runnable runnable, Throwable throwable) {
        super.afterExecute(runnable, throwable);
      }
    };

    threadPoolExecutor.execute(forLoopTask);
    Collection<Callable<BigInteger>> taskColletion = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      taskColletion.add(new ForLoopTask(1000));
    }
    long timeout = 100_000;
    List<Future<BigInteger>> futures = threadPoolExecutor.invokeAll(taskColletion, timeout, TimeUnit.MILLISECONDS);
    for (Future<BigInteger> future : futures) {
      //future.cancel(true);
      future.get();
    }
  }
}
