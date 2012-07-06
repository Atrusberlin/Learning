package de.hypoport.jop.multithreading.futures;

import de.hypoport.jop.multithreading.rest.CallBackTask;
import de.hypoport.jop.multithreading.tasks.ForLoopTask;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTest {

  private ThreadPoolExecutor threadPoolExecutor;

  @BeforeMethod
  protected void setUp() throws Exception {
    threadPoolExecutor = new ThreadPoolExecutor(20, 40, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
  }

  @Test
  public void testFutureGet() throws ExecutionException, InterruptedException {
    Future<String> future = threadPoolExecutor.submit(new StringCallable());

    while (!future.isDone() && !future.isCancelled()) {
      System.out.println("Task läuft noch, warte 1 Sekunde.");
      TimeUnit.SECONDS.sleep(1);
    }
    System.out.println("Ergebnis des asynchronen Aufrufs: " + future.get());
  }

  class StringCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
      System.out.println("StringCallable was started: " + Thread.currentThread().getId());
      Thread.sleep(5000);
      return "Aufruf beendet";
    }
  }
}
