package de.dranke.learning.ooplecture.rpncalculator;

public class Stack {

  private java.util.Stack<Integer> stack = new java.util.Stack();

  public void push(int number) {
    stack.push(number);
  }

  public int peek() {
    return isEmpty() ? 0 : stack.peek();
  }

  public int pop() {
    return isEmpty() ? 0 : stack.pop();
  }

  public int size() {
    return stack.size();
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }
}
