import java.io.*;
import java.util.*;

public class Driver{

  public static void main(String[] args) {
    Mode m = new Mode();

    System.out.println(m);
    // System.out.println("Smallest value: " + m.findSmallestValue());
    // System.out.println("Frequency of 10: " + m.frequency(10));
    // System.out.println("Frequency of 8: " + m.frequency(8));
    // System.out.println("Frequency of 2: " + m.frequency(2));
    // System.out.println("Frequency of 17: " + m.frequency(17));
    m.sort();
    System.out.println(m);
    System.out.println("Mode: " + m.calcMode());
    System.out.println("SuperMode: " + m.superCalcMode());
  }

}
