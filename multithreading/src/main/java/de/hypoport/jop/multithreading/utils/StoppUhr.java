package de.hypoport.jop.multithreading.utils;

import java.util.Date;

public class StoppUhr {

  long begin;

  public static StoppUhr startUhr() {
    StoppUhr stoppUhr = new StoppUhr();
    stoppUhr.start();
    return stoppUhr;
  }

  public void start() {
    begin = new java.util.Date().getTime();
  }

  public Double dauer() {
    long ende = new Date().getTime();
    Double secs = new Double((ende - begin) * 0.001);
    return secs;
  }

  public void gebeDauerAus() {

    System.out.println("Gesamtdauer " + dauer() + " secs");
  }
}
