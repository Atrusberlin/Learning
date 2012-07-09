package de.hypoport.jop.multithreading.callable;

import java.util.concurrent.Callable;

public class ExceptionThrowingCallable implements Callable<Object> {

  @Override
  public Object call() throws Exception {
    throw new Exception("Gewollte Exception aus dem Thread heraus.");
  }
}
