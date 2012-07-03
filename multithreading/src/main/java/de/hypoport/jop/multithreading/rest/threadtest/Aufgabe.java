package de.hypoport.jop.multithreading.rest.threadtest;

import de.hypoport.jop.multithreading.utils.StoppUhr;

import java.util.concurrent.Callable;

public class Aufgabe implements Callable {

  private int seq;
  private String str = "";

  public Aufgabe(int i) {
    seq = i;
  }

  public Object call() {
    StoppUhr uhr = StoppUhr.startUhr();
    try {
      simmuliereExternenCall();
      simmuliereErgebnisVerarbeitung();
    } catch (InterruptedException e) {
    }
    Double dauer = uhr.dauer();
    System.out.println("Dauer Aufgabe " + seq + " ->" + dauer + " secs");
    return seq;
  }

  private void simmuliereExternenCall() throws InterruptedException {
    Thread.sleep(1000);
  }

  private void simmuliereErgebnisVerarbeitung() {
    // Ergebnisverarbeitung
    for (int i = 0; i < 20000; i++) {
      str = str + 't';
    }
  }
}