import java.io.*;
import java.util.*;

public class Mario {

  public static void main(String[] args) {

    // part1boring();
    // part1repeat();
    // part2(4); // height of 4
    // part3(4,3); // height of 4, 3 pyramids
    part4(4,3); // height of 4, 3 pyramids, every other inverted

  }

  //    #  #
  //   ##  ##
  //  ###  ###
  // ####  ####
  public static void part1boring() {
    System.out.println("   #  #");
    System.out.println("  ##  ##");
    System.out.println(" ###  ###");
    System.out.println("####  ####");
  }

  // same as part1boring(), but using .repeat()
  public static void part1repeat() {
    System.out.println(" ".repeat(3) + "#".repeat(1) + "  " + "#".repeat(1));
    System.out.println(" ".repeat(2) + "#".repeat(2) + "  " + "#".repeat(2));
    System.out.println(" ".repeat(1) + "#".repeat(3) + "  " + "#".repeat(3));
    System.out.println(" ".repeat(0) + "#".repeat(4) + "  " + "#".repeat(4));
  }

  // prints a pyramid of custom height
  public static void part2(int height) {
    for(int level = 1; level <= height; level++) {
      System.out.println(" ".repeat(height-level) + "#".repeat(level) + "  " + "#".repeat(level));
    }
  }

  // prints a custom number of pyramids, with custom height
  // HINT: use part 2
  public static void part3(int height, int numPyramids) {
    for(int i = 0; i < numPyramids; i++) {
      part2(height);
    }
  }

  // same as part 2, but pyramid is upside-down
  // will help with part 4
  public static void part2inverted(int height) {
    for(int level = height; level >= 1; level--) {
      System.out.println(" ".repeat(height-level) + "#".repeat(level) + "  " + "#".repeat(level));
    }
  }

  // same as part 3, but every OTHER pyramid is upside-down
  public static void part4(int height, int numPyramids) {
    for(int i = 0; i < numPyramids; i++) {
      if(i%2 == 0){
        part2(height);
      }
      else {
        part2inverted(height);
      }
    }
  }

}
