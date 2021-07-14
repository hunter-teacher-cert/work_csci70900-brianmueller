import java.io.*;
import java.util.*;

public class Driver{
  public static void main(String[] args) {
    // DEMO
    // Node n;
    // n = new Node();
    // n.setData("Eduardo");
    //
    //
    // Node n2 = new Node("Brian");
    // n.setNext(n2);
    //
    // System.out.println(n);
    //
    // System.out.println(n2);
    //
    // System.out.println(n.getNext());
    // n.getNext().setNext(new Node("Steph"));
    // System.out.println(n2.getNext());
    // System.out.println(n.getNext().getNext());

    // TASK
    Node L = new Node();

    // 1.Create a new  list that looks like:
    //   L->"a"->"b"->"c"->"d"
    Node d = new Node("d");
    Node c = new Node("c",d);
    Node b = new Node("b",c);
    Node a = new Node("a",b);
    L.setNext(a);
    // System.out.println(L); // null
    // System.out.println(L.getNext()); // a
    // System.out.println(L.getNext().getNext()); // b
    // System.out.println(L.getNext().getNext().getNext()); // c
    // System.out.println(L.getNext().getNext().getNext().getNext()); // d

    // print out all nodes
    // Node tempNode = L;
    // while(tempNode != null){
    //   System.out.print(tempNode + " --> "); // prints extra -->
    //   tempNode = tempNode.getNext();
    // }









    // 2. Write the code to insert an "x"
    //    between the b and the c
    Node x = new Node("x");
    x.setNext(c);
    b.setNext(x);
    // System.out.println(L); // null
    // System.out.println(L.getNext()); // a
    // System.out.println(L.getNext().getNext()); // b
    // System.out.println(L.getNext().getNext().getNext()); // x
    // System.out.println(L.getNext().getNext().getNext().getNext()); // c
    // System.out.println(L.getNext().getNext().getNext().getNext().getNext()); // d

    // Node tempNode = L;
    // while(tempNode != null){
    //   System.out.print(tempNode + " --> "); // prints extra -->
    //   tempNode = tempNode.getNext();
    // }






    // 3. Write the code to delete the c
    x.setNext(d);
    // System.out.println(L); // null
    // System.out.println(L.getNext()); // a
    // System.out.println(L.getNext().getNext()); // b
    // System.out.println(L.getNext().getNext().getNext()); // x
    // System.out.println(L.getNext().getNext().getNext().getNext()); // d

    Node tempNode = L;
    while(tempNode != null){
      System.out.print(tempNode + " --> "); // prints extra -->
      tempNode = tempNode.getNext();
    }
  }
}
