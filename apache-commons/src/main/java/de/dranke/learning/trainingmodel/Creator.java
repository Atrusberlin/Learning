package de.dranke.learning.trainingmodel;

public class Creator {

  private String value;
  private String role;

  public Creator(String value, String role) {
    this.value = value;
    this.role = role;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
