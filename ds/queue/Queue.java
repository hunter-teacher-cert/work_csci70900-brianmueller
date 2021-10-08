// worked independently

import java.io.*;
import java.util.*;

// Create a class that represents a queue.
// This class should use a linked list with at least two pointers.

public class Queue{
  private Node front; // first in line
  private Node back; // last in line

  // constructor
  public Queue(){
    front = null;
    back = null;
  }

  public String toString(){
    Node currentNode;
    currentNode = front;
    String result = "";
    while (currentNode != null){
      result = result + currentNode + "->";
      currentNode = currentNode.getNext();
    }
    result = result + "null";
    return result;
  }

  // enqueue(value) <-- add value to the end of the queue
  public void enqueue(String value){
    Node newNode = new Node(value);
    if(front == null){ // empty
      front = newNode;
      back = newNode;
    } else {
      back.setNext(newNode);
      back = newNode;
    }
  }

  // x = dequeue() <-- remove and return the value at the front of the queue
  public Node dequeue(){
    Node firstInLine = front;
    front = front.getNext();
    return firstInLine;
  }

  // x = front() <-- return but don't remove the value at the front
  public Node front(){
    return front;
  }

  // isEmpty() <-- returns true if the queue is empty
  public boolean isEmpty(){
    return front == null;
  }

  // size() <-- returns the number of items in the queue
  public int size(){
    int counter = 0;
    Node currentNode = front;
    while(currentNode != null){
      counter++;
      currentNode = currentNode.getNext();
    }
    return counter;
  }

}
