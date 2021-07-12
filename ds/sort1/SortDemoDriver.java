// Brian Mueller
// Mamudu Wally
// Peter Tsun
// Lyuba Fridman

import java.io.*;
import java.util.*;

public class SortDemoDriver {
  public static void main(String[] args) {

    SortDemo sd = new SortDemo(); // default size: 15
    System.out.println(sd);

    SortDemo sd2 = new SortDemo(20);
    System.out.println(sd2);

    /* part 2 test lines */

    int i;
    i = sd.findSmallestIndex(10);
    System.out.println("sd["+ i + "] = "+sd.get(i)+" : " + sd);

    i = sd2.findSmallestIndex(15);
    System.out.println("sd2["+ i + "] = "+sd2.get(i)+" : " + sd2);


    /* part 3 test lines */

    System.out.println(sd);
    sd.sort();
    System.out.println(sd);

    System.out.println("Linear search, finding 10 in sd:  " + sd.linearSearch(10));
    System.out.println("Linear search, finding 20 in sd2: " + sd2.linearSearch(20));

    System.out.println("Binary search, finding 10 in sd: " + sd.binarySearch(10));


  }
}
