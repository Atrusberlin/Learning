package de.hypoport.jop.multithreading.spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static de.hypoport.jop.multithreading.utils.TestUtils.log;

@Service
public class TestService {

  @Async
  public Future<Integer> getInteger(Integer wertFuerTimeOutInSekunden) throws InterruptedException {
    log("Ausführung wird unterbrochen für " + wertFuerTimeOutInSekunden + " Sekunden.");
    TimeUnit.SECONDS.sleep(wertFuerTimeOutInSekunden);
    log("Auführung wird fortgesetzt.");

    return new AsyncResult<Integer>(wertFuerTimeOutInSekunden);
  }
}
