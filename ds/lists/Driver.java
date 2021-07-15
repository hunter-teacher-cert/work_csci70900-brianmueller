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

    // ONE way of printing
    // System.out.println(L); // null
    // System.out.println(L.getNext()); // a
    // System.out.println(L.getNext().getNext()); // b
    // System.out.println(L.getNext().getNext().getNext()); // c
    // System.out.println(L.getNext().getNext().getNext().getNext()); // d

    // ANOTHER way of printing
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

    // ONE way of printing
    // System.out.println(L); // null
    // System.out.println(L.getNext()); // a
    // System.out.println(L.getNext().getNext()); // b
    // System.out.println(L.getNext().getNext().getNext()); // x
    // System.out.println(L.getNext().getNext().getNext().getNext()); // c
    // System.out.println(L.getNext().getNext().getNext().getNext().getNext()); // d

    // ANOTHER way of printing
    // Node tempNode = L;
    // while(tempNode != null){
    //   System.out.print(tempNode + " --> "); // prints extra -->
    //   tempNode = tempNode.getNext();
    // }






    // 3. Write the code to delete the c
    x.setNext(d);

    // ONE way of printing
    // System.out.println(L); // null
    // System.out.println(L.getNext()); // a
    // System.out.println(L.getNext().getNext()); // b
    // System.out.println(L.getNext().getNext().getNext()); // x
    // System.out.println(L.getNext().getNext().getNext().getNext()); // d

    // ANOTHER way of printing
    // Node tempNode = L;
    // while(tempNode != null){
    //   System.out.print(tempNode + " --> "); // prints extra -->
    //   tempNode = tempNode.getNext();
    // }

    System.out.println("\n");
  	System.out.println("Llist");
  	System.out.println("-----------");

  	Llist ll = new Llist();
  	System.out.println(ll);
    System.out.println("ll.isEmpty(): " + ll.isEmpty());
    System.out.println("ll.length(): " + ll.length());

    ll.addFront("c");
    ll.addFront("b");
    ll.addFront("a");
    System.out.println(ll);

    // isEmpty
    System.out.println("ll.isEmpty(): " + ll.isEmpty());

    // length
    System.out.println("ll.length(): " + ll.length());

    // get
    System.out.println("ll.get(0): " + ll.get(0)); // a
    System.out.println("ll.get(2): " + ll.get(2)); // c
    System.out.println("ll.get(5): " + ll.get(5)); // null

    // set
    ll.set(0,"apple");
    System.out.println("ll.get(0): " + ll.get(0)); // apple
    ll.set(2,"carrot");
    System.out.println("ll.get(2): " + ll.get(2)); // carrot
    ll.set(5,"pear"); // shouldn't work
    System.out.println("ll.get(5): " + ll.get(5)); // null
    System.out.println(ll);

    // insert
    ll.insert(2,"banana");
    System.out.println(ll); // apple --> b --> banana --> carrot --> null

    // search
    System.out.println("ll.search('carrot'): " + ll.search("carrot")); // 3
    System.out.println("ll.search('tomato'): " + ll.search("tomato")); // -1

    // remove
    ll.remove(2);
    System.out.println(ll); // apple --> b --> carrot --> null

  }
}
