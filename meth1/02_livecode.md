_Note 1: this live coding activity builds upon [01_lesson.md](01_lesson.md)_

_Note 2: the final code is in [Mario.java](Mario.java)_

### Starter code
```java

import java.io.*;
import java.util.*;

public class Mario {

  public static void main(String[] args) {

    // part1boring();
    // part1repeat();
    // part2(4); // height of 4
    // part3(4,3); // height of 4, 3 pyramids
    // part4(4,3); // height of 4, 3 pyramids, every other inverted

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

  }

  // prints a pyramid of custom height
  public static void part2(int height) {

  }

  // prints a custom number of pyramids, with custom height
  // HINT: use part 2
  public static void part3(int height, int numPyramids) {

  }

  // same as part 2, but pyramid is upside-down
  // will help with part 4
  public static void part2inverted(int height) {

  }

  // same as part 3, but every OTHER pyramid is upside-down
  public static void part4(int height, int numPyramids) {

  }

}

```

### Part 2: make a table to find patterns between height and level

| height  | level   |    pyramid              |
| ------- | ------- |                         |
|         |         | _ _ _ # _ _ # _ _ _     |
|         |         | _ _ # # _ _ # # _ _     |
|         |         | _ # # # _ _ # # # _     |
|         |         | # # # # _ _ # # # #     |
| ------- | ------- | ----------------------- |
|         |         | _ _ _ _ # _ _ # _ _ _ _ |
|         |         | _ _ _ # # _ _ # # _ _ _ |
|         |         | _ _ # # # _ _ # # # _ _ |
|         |         | _ # # # # _ _ # # # # _ |
|         |         | # # # # # _ _ # # # # # |

* What kind of math can we do, using the height and the level, to get the number of leading spaces? What about the number of `#`?
* How can we generalize this to predict the number of leading spaces in a pyramid with _any_ height and on _any_ level?
* What do you notice about the number of inside spaces?
* Do we need to add the trailing spaces? Why or why not?
* What starting/ending values make sense for our `for` loop?
  * Pause for prediction: what will it look like if we use our typical values: `for(int i = 0; i < height; i++)`?

### Part 3:
* How can we use `part2()` to help us with `part3()`?

### Part 2 inverted:
* Why might we need this method? How would it help us with Part 4? What would happen if we didn't write this method?
* How can we approach our `for` loop? (starting value, condition, change). Are there other approaches?

### Part 4:
* What do you notice about the `i` values? How can we use the `i` value to help us alternate the direction of the pyramids?
