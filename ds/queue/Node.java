import java.io.*;
import java.util.*;

public class Node {

  private String data;
  private Node next;

  public Node() {
    data = "";
    next = null;
  }

  public Node(String value) {

    data = value;
    next = null;
  }

  public Node(String value, Node next) {
    data = value;
    this.next = next;
  }

  public void setData(String value) {
    data = value;
  }

  public void setNext(Node n) {
    next = n;
  }

  public String getData() {
    return data;
  }

  public Node getNext() {
    return next;
  }

  public String toString() {
    return data;
  }

}
