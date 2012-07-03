package de.hypoport.jop.multithreading.rest.threadtest;

import de.hypoport.jop.multithreading.utils.StoppUhr;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {

  private static int ANZAHL_AUFGABEN = 6;
  private static int ANZAHL_THREADS = 6;
//    private static int ANZAHL_THREADS = Runtime.getRuntime().availableProcessors();

  public void fuehreTestAus() {
    StoppUhr uhr = StoppUhr.startUhr();

    List<Future> futuresList = new ArrayList<Future>();

    erstelleAufgabenAlsFuture(futuresList);
    verarbeiteFutureErgebnis(futuresList);

    uhr.gebeDauerAus();
  }

  private void erstelleAufgabenAlsFuture(List<Future> futuresList) {
    System.out.println("Prozessoren: " + Runtime.getRuntime().availableProcessors());
    System.out.println("Anzahl Threads: " + ANZAHL_THREADS);
    System.out.println("Anzahl Aufgaben: " + ANZAHL_AUFGABEN);
    ExecutorService executorService = Executors.newFixedThreadPool(ANZAHL_THREADS);
    for (int index = 0; index < ANZAHL_AUFGABEN; index++) {
      Aufgabe aufgabe = new Aufgabe(index);
      Future future = executorService.submit(aufgabe);
      futuresList.add(future);
    }
  }

  private void verarbeiteFutureErgebnis(List<Future> futuresList) {
    Object taskResult;
    for (Future future : futuresList) {
      try {
        taskResult = future.get();
//        System.out.println("Ergebnis aus future " + taskResult);
      } catch (InterruptedException e) {
      } catch (ExecutionException e) {
      }
    }
  }

  public static void main(String[] args) {
    new ExecutorServiceTest().fuehreTestAus();
    System.exit(0);
  }
}