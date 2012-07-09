package de.hypoport.jop.multithreading.callable;

import java.util.concurrent.Callable;

import static de.hypoport.jop.multithreading.utils.TestUtils.log;

class StringCallable implements Callable<String> {

  @Override
  public String call() throws Exception {
    log("StringCallable wurde gestartet. call() ");
    Thread.sleep(5000);
    return "Aufruf beendet";
  }
}
