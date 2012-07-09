package de.hypoport.jop.multithreading.futures;

import de.hypoport.jop.multithreading.tasks.AbstractForLoopTask;
import de.hypoport.jop.multithreading.utils.StoppUhr;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.concurrent.*;

import static de.hypoport.jop.multithreading.utils.TestUtils.log;
import static org.fest.assertions.Assertions.assertThat;

public class FutureTest {

  private ThreadPoolExecutor threadPoolExecutor;

  @BeforeMethod
  protected void setUp() throws Exception {
    threadPoolExecutor = new ThreadPoolExecutor(20, 40, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
  }

  @Test
  public void get_blockiert_den_Hauptthread() throws ExecutionException, InterruptedException {
    Future<String> future = threadPoolExecutor.submit(new StringCallable());

    StoppUhr stoppUhr = StoppUhr.startUhr();
    log("Vor dem future.get()");
    String futureErgebnis = future.get();
    log("Ergebnis des Futures:" + futureErgebnis);
    stoppUhr.gebeDauerAus();

    assertThat(futureErgebnis).isEqualTo("Aufruf beendet");
  }

  @Test
  public void isDone_prueft_ob_der_Task_erledigt_ist_ohne_den_Hauptthread_zu_blockieren() throws ExecutionException, InterruptedException {
    Future<String> future = threadPoolExecutor.submit(new StringCallable());

    StoppUhr stoppUhr = StoppUhr.startUhr();
    while (!future.isDone()) {
      log("FutureTask ist noch nicht beendet.");
      TimeUnit.SECONDS.sleep(1);
    }
    log("Vor dem future.get()");
    String futureErgebnis = future.get();
    stoppUhr.gebeDauerAus();
    log("Ergebnis des Futures: " + futureErgebnis);
  }

  @Test(expectedExceptions = CancellationException.class)
  public void cancel_wirft_CancelationException_bei_get() throws InterruptedException, ExecutionException {
    Callable<BigInteger> callable = new BigintCallable(100_000);
    Future<BigInteger> future = threadPoolExecutor.submit(callable);
    TimeUnit.SECONDS.sleep(1);
    log("Future.cancel(true) wird aufgerufen.");
    future.cancel(true);

    log("Ergebnis des Futures: " + future.get());

    log("CancellationException wurde geworfen.");
    assertThat(future.isCancelled()).isTrue();
  }

  class StringCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
      log("StringCallable wurde gestartet. call() ");
      Thread.sleep(5000);
      return "Aufruf beendet";
    }
  }

  class BigintCallable extends AbstractForLoopTask {

    protected BigintCallable(int maxIterations) {
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
}
