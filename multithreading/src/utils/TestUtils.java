package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {

  public static void log(Object text) {
    String timeStamp = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());
    System.out.println(timeStamp + " [" + threadId() + "] " + text.toString());
  }

  public static void sleep(long millis) throws InterruptedException {
    log("start sleeping " + millis + " ...");
    Thread.sleep(millis);
    log("... woke up");
  }

  private static String threadId() {
    return Thread.currentThread().getName() + Thread.currentThread().getId();
  }
}
