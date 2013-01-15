package de.dranke.learning.trainingmodel;

import java.util.ArrayList;
import java.util.Collection;

public class Book {

  private String title;

  private ArrayList<Creator> creator;

  public Book(String title) {
    this.title = title;
    creator = new ArrayList<>(2);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Collection<Creator> getCreator() {
    return creator;
  }

  public void addCreator(Creator creator) {
    this.creator.add(creator);
  }

  public void addCreator(Creator... creators) {
    for (Creator creator : creators) {
      addCreator(creator);
    }
  }

}
