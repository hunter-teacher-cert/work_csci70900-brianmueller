// Brian Mueller
// Mamudu Wally
// Peter Tsun
// Lyuba Fridman

// MERGE SORT
// Victoria Berkowitz
// Michele P

import java.io.*;
import java.util.*;

/*
Setup:
1.Make a folder under your work repo named: ds
2. Make another folder under that named sort1
3. Copy this file and SortDemoDriver.java into the ds/sort1 folder
Lab:
Part 1:
1. Analyze the two constructors - try to figure out how they work.
2. Compile and run the program (SortDemoDriver.java and SortDemo.java) and confirm
the behavior of the constructors.
Part 2:
1. Read the description of findSmallestIndex and complete the method.
2. Uncomment the lines in SortDemoDriver to test.
Part 3:
1. Complete the sort method - read comments for description
2. Uncomment the lines in sortDemoDriver to test.
*/

public class SortDemo{

  /* Instance Variables */
  private ArrayList<Integer> data;  // to store the data
  private Random r;


  public SortDemo(){
    data = new ArrayList<Integer>();
    r = new Random();
    for (int i=0;i<15;i++){
      data.add(r.nextInt(20)); // [0,19]
    }

  }

  public SortDemo(int size){
    data = new ArrayList<Integer>();
    r = new Random();
    for (int i=0;i<size;i++){
      data.add(r.nextInt(20));
    }

  }

  public int get(int i) {
    return data.get(i);
  }

  /*
  return the index of the ArrayList data from index start to the end
  Example, if the arraylist has:
  5,3,10,6,8
  if start was 2 (start at index 2, value 10) then it woudl return 3 which is the index of the value
  6 which is the index with the smallest value from start to end
  */
  public int findSmallestIndex(int start){
    int smallIndex = start;

    // start a variable at the one after start
    // your code here
    // int tempIndex = start+1;
    int smallestSoFar = data.get(smallIndex);
    // loop from that variable to end and update smallIndex as needed
    // your code here
    for(int i = start; i < data.size(); i++){
      // if current value < smallestSoFar, update smallestSoFar and smallIndex
      if(data.get(i) < smallestSoFar){
        smallestSoFar = data.get(i);
        smallIndex = i;
      }
    }

    return smallIndex;

  }


  // Part 3
  public void sort(){ // selection sort
    int i;
    for (i=0;i < data.size()-1; i++){
      // find the smallet index from i to end
      // your code here
      int smallestIndex = this.findSmallestIndex(i);

      // swap the item at that index and i
      // your code here
      int temp = data.get(i);

      // data[i] = data[smallestIndex]
      data.set(i, data.get(smallestIndex));
      data.set(smallestIndex, temp);


    }
  }



  /* If you finish the lab early you can get started on this */
  public int linearSearch(int value){
    // loop through the ArrayList data
    // and if the value you're searchign for is in the ArrayList, return it.
    // return -1 if it isn't there.
    for(int i = 0; i < data.size(); i++) {
      if(data.get(i).equals(value)){
        return value;
      }
    }
    return -1; // else/default
  }

  /* If you finish the lab early you can get started on this */
  public int binarySearch(int value){

    int lowerIndex = 0;
    int upperIndex = data.size();
    int middleIndex = data.size()/2;
    boolean lowerLessThanUpper = lowerIndex < upperIndex;

    // PSEUDOCODE
    // repeat while lowerIndex less than upperIndex
      // if middleElement == input, return middleElement
      // else
        // if input > middleElement, lowerIndex = middleIndex
        // if input < middle, upperIndex = middleIndex
    // return -1


    /* if upper crosses lower it's not there and the lop should exit the loop
    and if the item is at middle you should exit the loop
    you have to replace the "replacethiswithrealexpression" boolean
    with a correct expression based on lowerIndex and upperIndex
    */
    while (lowerLessThanUpper)
    {
      // update lower and upper.
      // remember if value is less than data.get(middleIndex) you want to search next time
      // from lower to the middle and otherwise from the middle to the upper.
      //
      // then update middleIndex based on new lowerIndex and upperIndex.

      // if middleElement == input, return middleElement
      if(data.get(middleIndex).equals(value)){
        return data.get(middleIndex);
      } else {
        if(value > data.get(middleIndex)){ // if input > middleElement, lowerIndex = middleIndex
          lowerIndex = middleIndex+1;
        } else { // if input < middle, upperIndex = middleIndex
          upperIndex = middleIndex-1;
        }
        middleIndex = (upperIndex - lowerIndex)/2; // update middleIndex
      }
      lowerLessThanUpper = lowerIndex < upperIndex;

    }

    /* replace this return to either return the value if it was found and -1
    if upperIndex and lowerIndex crossed
    */

    return -1; // else/default
  }


  public String toString(){
    return ""+data;
  }



  /*------------------------- MERGESORT STUFF -----------------*/

  // Preconditions: a and b are ArrayLists of Integers and
  //                both are in increasing order
  // Return: a new ArrayList of Integers that is the result
  //         of merging a and b. The new ArrayList
  //         should be in increasing order
  // a: 1,3,7,9,10
  // b: 2,6,8
  // merged: 1,2,3,6,7,8,9,10
  // a: 9,10
  // b:
  // merged: 1,2,3,6,7,8

  // a: 1,3,7,9,10
  // b: 2,6,8
  //  a.remove(0) --> remove 1
  // a: 3,7,9,10
  // a.get(0) --> 3

  private ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
    //create new ArrayList called merged to store merged values into
    ArrayList<Integer> mergedData = new ArrayList<Integer>();
    // until both are empty
    while( !a.isEmpty() || !b.isEmpty() ){ // a has element(s) OR b has element(s): but both aren't empty
      if(a.isEmpty() && !b.isEmpty()){ // take b
        mergedData.add(b.remove(0));
      } else if(!a.isEmpty() && b.isEmpty()) { // take a
        mergedData.add(a.remove(0));
      } else { // neither empty, take smaller
        if(a.get(0) > b.get(0)){ // take b
          mergedData.add(b.remove(0));
        } else { // take a
          mergedData.add(a.remove(0));
        }
      }
    }

    return mergedData;
  }


  private ArrayList<Integer> fillForMerge(int size){
    ArrayList<Integer> a = new ArrayList<Integer>();
    int lastVal = r.nextInt(10);
    for (int i = 0 ; i < size ; i=i+1){
      a.add(lastVal);
      lastVal = lastVal + r.nextInt(10); //add a random number to last digit so array is sorted
    }
    return a;

  }
  public void testMerge(){

    ArrayList<Integer> a = new ArrayList<Integer>();
    ArrayList<Integer> b = new ArrayList<Integer>();
    a = fillForMerge(20);
    b = fillForMerge(15);
    System.out.println(a);
    System.out.println(b);
    ArrayList<Integer> abMerged = merge(a,b);
    System.out.println("a and b merged: " + abMerged);
  }

  // a: 5,1,8,9,3,6
  // mergeSort(a) ==> 1,3,5,6,8,9
  public ArrayList<Integer> mergeSort(ArrayList<Integer> a){
    // break down to arraylists of size 1
    // base case: if there are less than 2 elements in the array it is already sorted
    if(a.size() == 1){
      return a;
    }

    // big picture: split to L and R, sortL and sortR, merge(sortedL,sortedR)

    //create the left side of the arraylist
    // ArrayList<Integer> left = a.subList(0,a.size()/2); // subList returns List<Integer>
    ArrayList<Integer> left = new ArrayList<Integer>(a.subList(0,a.size()/2));

    //create the right side of the arraylist
    ArrayList<Integer> right = new ArrayList<Integer>(a.subList(a.size()/2, a.size()));

    left = mergeSort(left);
    right = mergeSort(right);

    // merge left and right
    ArrayList<Integer> result = merge(left,right);

    return result;

  }

  public void mergeSortTest(){
    data = mergeSort(data);
  }

}
