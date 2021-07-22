// EXAMPLE:
// 5, 3, 2, 8, 12, 15, 9, 6, 14, 1
// partition based on 9
  // <= 9 on left, > 9 on right
  // pivot value random: O(n^2)
  // pivot value median: O(n log n)
  // strategy: take median of a[0], a[middle], a[last]
// 5, 3, 2, 8, 6, 1, |9|, 12, 15, 14
  // 9 is now in its correct final location
// repeat process with left and right side as their own data set
// 2, 1, |3|, 5, 8, 6
// |1|, 2
// base case: size 0 or 1
// can use an array for in-place sort because you don't need to make a new array, but the code can get hairy
// recommendation: use an extra array(list) and copy over the data (L+pivot+R)

// PSEUDOCODE
/*
qsort(data){
  pivot = a value from data
  partition data around pivot
  qsort(left)
  qsort(right)
}
*/

import java.io.*;
import java.util.*;

public class Qsort{

  private ArrayList<Integer> data;
  private Random r;


  public Qsort(){
    data = new ArrayList<Integer>();
    r = new Random();
    for (int i=0;i<15;i++){
      data.add(r.nextInt(20)); // [0,19]
    }
  }

  public Qsort(int size){
    data = new ArrayList<Integer>();
    r = new Random();
    for (int i=0;i<size;i++){
      data.add(r.nextInt(20));
    }
  }

  public String toString(){
    return ""+data;
  }

  public ArrayList<Integer> sort(ArrayList<Integer> q){

    if(q.size() < 2){
      return q;
    }

    // find optimal pivot point
    int first = q.get(0);
    int middle = q.get(q.size()/2);
    int last = q.get(q.size()-1);
    // System.out.println("first: " + first);
    // System.out.println("middle: " + middle);
    // System.out.println("last: " + last);
    int pivotIndex;
    int pivotValue;
    if(first < middle && middle < last){ // middle
      pivotIndex = q.size()/2;
      pivotValue = middle;
    } else if(middle < first && first < last){ // first
      pivotIndex = 0;
      pivotValue = first;
    } else { // last
      pivotIndex = q.size()-1;
      pivotValue = last;
    }

    // sort based on pivot
    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();
    for(int i = 0; i < q.size(); i++){
      if(i != pivotIndex){ // skip pivot
        int currentValue = q.get(i);
        if(currentValue <= pivotValue){
          left.add(currentValue);
        } else {
          right.add(currentValue);
        }
      }
    }

    // recursive calls
    left = sort(left);
    right = sort(right);

    // merge
    left.add(q.get(pivotIndex)); // left+pivot
    left.addAll(right); // left+pivot+right

    return left;
  }

  public void sortTest(){
    data = sort(data);
  }

}
