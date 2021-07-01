// Brian Mueller
// Emma Wingreen
// Peter Tsun

/** skeleton file for
 class twoDimArray
  ...practice working with 2D arrays
*/
public class TwoDimArray
{
  //print each row of 2D integer array a on its own line,
  // using a FOR loop
  public static void print1( int[][] a ) {
    for(int row = 0; row < a.length; row++) {
      for(int column = 0; column < a[row].length; column++){
        System.out.print(a[row][column] + " ");
      }
      System.out.println();
    }
  }
  //print each row of 2D integer array a on its own line,
  // using a FOREACH loop
  public static void print2( int[][] a ) {
    for(int[] row: a){
      for(int column: row){ // column = value/cell/int/element
        System.out.print(column + " ");
      }
      System.out.println();
    }
  }
  //return sum of all items in 2D integer array a
  public static int sum1( int[][] a ) {
    //Initialize a variable for the sum
    int sum = 0;
    //Create nested for loops to access each element
    for (int row = 0; row < a.length; row++) {
      for (int column = 0; column < a[row].length; column ++) {
        //Add each element to the running total
        sum += a[row][column];
      }
    }
    //Return the total sum
    return sum;
  }
  //return sum of all items in 2D integer array a
  // using helper fxn sumRow
  public static int sum2( int [][] m ) {
    //Initialize a variable for the sum1
    int sum = 0;
    //Create a for loop to add each row in the array
    for (int row = 0; row < m.length; row++){
      //Call the sumRow helper function with the
      //row indicated and the m[][] array
      sum += sumRow(row,m);
    }
    return sum;
  }
  //return sum of all items on row r of 2D integer array a
  // using a FOR loop
  public static int sumRow( int r, int[][] a ) {
    //Initialize a variable for the sum
    int sum = 0;
    //Create a for loop that adds each column element
    //to the running total sum
    for (int column = 0; column < a[r].length; column++){
      sum += a[r][column];
    }
    //Return the sum
    return sum;
  }
  //return sum of all items on row r of 2D integer array a
  // using a FOREACH loop
  public static int sumRow2( int r, int[][] m ) {
    //Initialize sum variable to 0
    int sum = 0;
    //Create nested FOREACH loops to add the running total
    for(int column: m[r]){
      sum += column;
    }
    //Return running total
    return sum;
  }
  public static void main( String [] args )
  {
       int [][] m1 = new int[4][2];
       int [][] m2 = { {2,4,6}, {3,5,7} };
       int [][] m3 = { {2}, {4,6}, {1,3,5} };
      //  print1(m1);
      //  print1(m2);
      //  print1(m3);
      //  print2(m1);
      //  print2(m2);
      //  print2(m3);
       System.out.print("testing sum1...\n");
       System.out.println("sum m1 : " + sum1(m1));
       System.out.println("sum m2 : " + sum1(m2));
       System.out.println("sum m3 : " + sum1(m3));
      //  System.out.print("testing sum2...\n");
      //  System.out.println("sum m1 : " + sum2(m1));
      //  System.out.println("sum m2 : " + sum2(m2));
      //  System.out.println("sum m3 : " + sum2(m3));
      //  System.out.print("testing sumRow2...\n");
      //  System.out.println("sum m1[0] : " + sumRow2(0,m1));
      //  System.out.println("sum m2[0] : " + sumRow2(0,m2));
      //  System.out.println("sum m3[0] : " + sumRow2(0,m3));
           /* ~~~v~~~~~slide~me~down~as~you~test~~~~~~~~~~~~~~~v~~~
       ~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~*/
  }//end main()
}//end class TwoDimArray