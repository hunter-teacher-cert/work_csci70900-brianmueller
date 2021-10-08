## Lesson objective: Practice using methods in conjunction with loops

### Aim: How do we make Mario pyramids using methods and loops?

### Warm up
time: 5-10 minutes

#### Part I: The Boring Pyramid
Create a program that will print the following pyramid:

```
   #  #
  ##  ##
 ###  ###
####  ####
```
(The height and the width of the half-pyramids pictured above are 4 with a gap of size 2 separating them.)

* Students attempt this, then we go over it.

---

### Lesson Content
time: 10-15 minutes

#### Part II: User Specified Height
Add a new feature to your program that asks a user how tall they would like to make the pyramid. This should be a non-negative integer no greater than 23 (this is the tallest that a pyramid can be in Mario land).

* Most students will do part 1 using four `print` statements, but we refactor it using a loop to lead us into part II. Students attempt Part II for a few minutes, then we spend a few minutes going over it.

---

### Lesson Activity
time: 15 minutes

#### Part III: Chained pyramids

Modify your code to prompt the user for the number of pyramids they want. Using this number, stack the pyramids on top of each other in a chain. This would be an example of a pyramid with height of 4 and chain length of 3:
```
   #  #
  ##  ##
 ###  ###
####  ####
   #  #
  ##  ##
 ###  ###
####  ####
   #  #
  ##  ##
 ###  ###
####  ####
```
Hint: write a method that calls the method from Part II.

#### Part IV: Every-Other-Upside-Down Pyramid (extension)
Modify your code to make every other pyramid inverted. Example:
```
   #  #
  ##  ##
 ###  ###
####  ####
####  ####
 ###  ###
  ##  ##
   #  #
   #  #
  ##  ##
 ###  ###
####  ####
```


---

### Closing
time: 5-10 minutes
* Have volunteer(s) show how they did Part III, and if time, Part IV.

---
