package rest;

import utils.StoppUhr;

import java.util.concurrent.Callable;

public class CallBackTask implements Callable {

  private CallBackTest callBackTest;
  private int seq;

  public CallBackTask() {
  }

  public CallBackTask(int i) {
    seq = i;
  }

  public Object call() {
    String str = "";
    StoppUhr uhr = StoppUhr.startUhr();
    long begTest = new java.util.Date().getTime();
    System.out.println("start - Task " + seq);
    try {
      // sleep for 1 second to simulate a remote call,
      // just waiting for the call to return
      Thread.sleep(1000);
      // loop that just concatenate a str to simulate
      // work on the result form remote call
      for (int index = 0; index < 20000; index++) { str = str + 't'; }
    }
    catch (InterruptedException e) {}

    callBackTest.callBack(seq);

    Double secs = new Double((new java.util.Date().getTime() - begTest) * 0.001);
    secs = uhr.dauer();
    System.out.println("task -" + seq + " took " + secs + " secs");
    return null;
  }

  public void setCaller(CallBackTest callBackTest) {
    this.callBackTest = callBackTest;
  }

  public CallBackTest getCaller() {
    return callBackTest;
  }
}