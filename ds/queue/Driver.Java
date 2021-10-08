import java.io.*;
import java.util.*;

public class Driver{
  public static void main(String[] args) {

    // constructor(s)
    Queue q = new Queue();
    System.out.println(q);

    // enqueue(value) <-- add value to the end of the queue
    q.enqueue("Apples");
    q.enqueue("Bananas");
    q.enqueue("Carrots");
    System.out.println("Queue: " + q); // Apples->Bananas->Carrots->null

    // x = dequeue() <-- remove and return the value at the front of the queue
    System.out.println("Up next: " + q.dequeue()); // Apples
    System.out.println("Up next: " + q.dequeue()); // Bananas
    System.out.println("Queue: " + q); // Carrots->null

    // x = front() <-- return but don't remove the value at the front
    System.out.println("Front: " + q.front()); // Carrots

    // isEmpty() <-- returns true if the queue is empty
    System.out.println("Empty: " + q.isEmpty()); // false
    System.out.println("Up next: " + q.dequeue()); // Carrots
    System.out.println("Empty: " + q.isEmpty()); // true

    // size() <-- returns the number of items in the queue


  }
}
