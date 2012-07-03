package de.hypoport.jop.multithreading.spring;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class TestService {

  @Async
  public Future<Integer> getInteger(Integer wertFuerTimeOutInSekunden) throws InterruptedException {
    long timeOut = wertFuerTimeOutInSekunden * 1000;
    System.out.println("ThreadID: " + Thread.currentThread().getId() + " ;stop (" + timeOut + ")");
    Thread.currentThread().sleep(timeOut);
    System.out.println("ThreadID: " + Thread.currentThread().getId() + " wird fortgesetzt.");

    return new AsyncResult<Integer>(wertFuerTimeOutInSekunden);
  }
}
