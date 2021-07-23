// Group 4
// Chris O'Brien
// Stephannia Kabanakis
// Brian Mueller

import java.io.*;
import java.util.*;



public class Mode{
  private ArrayList<Integer> inputData;
  private Random r;
  public Mode(){
    r = new Random();
    inputData = new ArrayList<Integer>();

    for (int i=0; i < 20; i++){
      inputData.add(r.nextInt(20));
    }
  }
  public Mode(int size){
    r = new Random();
    inputData = new ArrayList<Integer>();

    for (int i=0; i < size; i++){

      inputData.add(r.nextInt(50));
    }
  }

  /**
  * Warmup 1

  Find and return the smallest value in  InputData.
  */

  public int findSmallestValue(){
  //  inputData = inputData.sort();
  //  System.out.println("unsorted: " + inputData);
  //sort data
    Collections.sort(inputData);
  //  System.out.println("sorted: " + inputData);
    return inputData.get(0);
  }

  /**
  * Warmup 2

  Returns the frequency of value in inputData, that is, how often value appears
  */
  public int frequency(int value){
    int count = 0;
    for(int i=0; i<inputData.size(); i++){
      if(value == inputData.get(i)){
      count++;
      } //end if
    } //end for loop
    return count;
  }
  // get ith elemetn of inputdata
  public int get(int i){
    return inputData.get(i);
  }

  public void sort(){
    Collections.sort(inputData);
  }

  /**
  *
  This function should calculate and return the mode of inputData.
  The mode is the value that appears most frequently so if inputData contained
  5,3,8,2,5,9,12,5,12,6,5, the mode would return 5 since 5 appears four times.

  If there are multiple modes such as in the case with this data set: 5,5,2,9,9,6 you should return
  either of them (the 5 or the 9).

  Note: you will probably use the frequency function you wrote in
  this solution but not findSmallestValue. the findSmallestValue
  function will help you find a strategy for approaching finding the mode.

  */
  public int superCalcMode(){
    Collections.sort(inputData); // allows us to not check a number that's already been checked
    int currentValue = 0;
    int currentFreq = 0;
    int value = inputData.get(0);
    int freq = frequency(value);
    for (int i = 1; i < inputData.size(); i++){
      if (inputData.get(i) != inputData.get(i-1)){ // if they're different, i.e. a new/different number
        currentValue = inputData.get(i);
        currentFreq = frequency(currentValue);
        if (currentFreq > freq){
          value = currentValue;
          freq = currentFreq;
        }
      }
    }
    return value;
  }

  public int calcMode(){


    // loop through every number
    // count frequency of each number
    // keep track of "reigning champ"
    /* [ 2 3 2 4]
    currentV = 2
    current Freq = 2
    value = 2
    freq = 2

    current 3
    currentF = 1

    */
    int value = 0;
    int freq = 0;
    // [ 2   3   2   4 4 4 4 1]
    for (int i = 0; i < inputData.size(); i++ ){
      int currentValue = inputData.get(i);
      int currentFreq = frequency(currentValue);
      if (currentFreq > freq){
        value = currentValue;
        freq = currentFreq;
      }
    }
    return value;
  }

  // make an array with size that matches the highest possible random number generated
  // set all to 0
  // iterate through inputData, get the value, use THAT as the index, and increment (add a tally)
  // public int fastMode(){
  //
  // }

  public String toString(){
    return ""+inputData;
  }
}
