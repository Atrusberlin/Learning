package de.hypoport.jop.multithreading.callable;

import de.hypoport.jop.multithreading.utils.StoppUhr;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.concurrent.*;

import static de.hypoport.jop.multithreading.utils.TestUtils.log;
import static org.fest.assertions.Assertions.assertThat;

public class FutureTest {

  private ThreadPoolExecutor threadPoolExecutor;

  @BeforeClass
  protected void init() throws Exception {
    threadPoolExecutor = new ThreadPoolExecutor(20, 40, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
  }

  @AfterClass
  protected void tearDown() {
    threadPoolExecutor.shutdownNow();
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

  @Test(expectedExceptions = TimeoutException.class)
  public void get_kann_mit_TimeOut_Parameter_aufgerufen_werden() throws ExecutionException, TimeoutException, InterruptedException {
    Future<String> future = threadPoolExecutor.submit(new StringCallable());

    future.get(1, TimeUnit.SECONDS);
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

    // get() liefert die CancellationException zurück
    future.get();

    log("CancellationException wurde geworfen.");
    assertThat(future.isCancelled()).isTrue();
  }

  @Test(expectedExceptions = ExecutionException.class)
  public void callables_reichen_auch_Exceptions_durch() throws ExecutionException, InterruptedException {
    Future<Object> future = threadPoolExecutor.submit(new ExceptionThrowingCallable());

    // bei get() wird die Exception in eine ExecutionException gewrapped und ausgeliefert.
    future.get();
  }
}
