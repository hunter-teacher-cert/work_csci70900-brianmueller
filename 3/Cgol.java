/*
Programming in a High Level Language
In Class assignment - 7/1/21
Mancala
by
Emma Wingreen
Peter Tsun
Brian Mueller
*/

import java.io.*;
import java.util.*;

/**
   The Rules of Life:
   Survivals:
   * A cell with 2 or 3 living neighbours will survive for the next generation.
   Death:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/

public class Cgol
{

  //initialize empty board (all cells dead)
  public static char[][] createNewBoard(int rows, int cols) {
    //Initialize a new array of characters
    char[][] a = new char[rows][cols];

    //Use a nested for loop to initialize the empty board
    for(int i = 0; i < a.length; i++){
        for(int j = 0; j < a[i].length; j++){
            a[i][j] = '-';
        }
    }

    //Return the initialized array
    return a;
  }

  //print the board to the terminal
  public static void printBoard(char[][] board) {
    //Use a nested for loop to print each cell in the board
    for(int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++){
        System.out.print(board[row][col] + " ");
      }
      System.out.println();
    }
  }

  // line 40 broke when we did board[row][col] + ' '
  // int + int ==> int
  // str + str ==> str
  // str + int ==> str
  // char + str ==> str
  // char + char ==> unicode conversion???
  // Gen X:
  // 77120777777
  // 77771207777
  // 1201201207777
  // 7777777777
  // 7777777777

  //set cell (r,c) to val
  public static void setCell(char[][] board, int r, int c, char val){
    //Set the element at board[r][c] to the given value: dead (-) or alive (X)
    board[r][c] = val;
  }

  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) {
    int livingNeighbors = 0;
    for(int i = r-1; i <= r+1; i++){ // from one row before to one after
      if(i >= 0 && i < board.length){ // within row bounds
        for(int j = c-1; j <= c+1; j++){ // from one column before to one after
          if(j >= 0 && j < board[r].length){ // within column bounds
            if(board[i][j] == 'X'){ // cell is alive
              livingNeighbors++; // add to livingNeighbors
            }
          }
        } // end for:j
      }
    } // end for:i
    if(board[r][c] == 'X'){ // if current cell alive...
      livingNeighbors -= 1; // ...it's not a 'neighbor'
    }

    return livingNeighbors;
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell(char[][] board,int r, int c) {
    char nextGenCell = '-'; // default: dead stays dead
    if(board[r][c] == 'X'){ // For a space that is populated:
      // Each cell with one or no neighbors dies, as if by solitude.
      // Each cell with four or more neighbors dies, as if by overpopulation.
      // Each cell with two or three neighbors survives.
      if(countNeighbours(board, r, c) < 2 || countNeighbours(board, r, c) > 3){
        nextGenCell = '-'; // alive becomes dead
      } else {
        nextGenCell = 'X'; // alive stays alive
      }
    } else if (countNeighbours(board,r,c) == 3) { // already know it's not populated
        nextGenCell = 'X'; // Each cell with three neighbors becomes alive. (dead becomes alive)
    } // only other possibility: dead stays dead
    return nextGenCell;
  }

  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {
    char[][] newBoard = new char[board.length][board[0].length]; // same dimensions as board
    for (int row = 0; row < board.length; row++) { //iterate through the rows of the 2D array

      for (int cell = 0; cell < board[row].length; cell++) {//iterate through the elements of the 2D array
        newBoard[row][cell] = getNextGenCell(board, row, cell); // approach 1
        // setCell(newBoard,row,cell,getNextGenCell(board,row,cell)); // approach 2
      }

    }
    return newBoard;
  }

  public static void main( String[] args )
  {

    char[][] board;
    board = createNewBoard(5,5);
    printBoard(board);

    //breathe life into some cells:
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 2, 'X');
    setCell(board, 2, 0, 'X');
    setCell(board, 2, 1, 'X');
    setCell(board, 2, 2, 'X');
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");

    // testing countNeighbors()
    // System.out.println("0,0 living neighbors: " + countNeighbours(board,0,0)); // should be 2
    // System.out.println("0,1 living neighbors: " + countNeighbours(board,0,1)); // should be 2
    // System.out.println("1,0 living neighbors: " + countNeighbours(board,1,0)); // should be 2
    // System.out.println("1,1 living neighbors: " + countNeighbours(board,1,1)); // should be 3
    // System.out.println("2,0 living neighbors: " + countNeighbours(board,2,0)); // should be 1
    // System.out.println("4,4 living neighbors: " + countNeighbours(board,4,4)); // should be 0
    // System.out.println("4,0 living neighbors: " + countNeighbours(board,4,0)); // should be 0
    // System.out.println("0,4 living neighbors: " + countNeighbours(board,0,4)); // should be 0
    // System.out.println("3,0 living neighbors: " + countNeighbours(board,3,0)); // should be 0
    // System.out.println("5,0 living neighbors: " + countNeighbours(board,5,0)); // should be error

    // testing getNextGenCell()
    // int myR = 0;
    // int myC = 0;
    // System.out.println(myR + ", " + myC + " next gen: " + getNextGenCell(board,myR,myC)); // X
    // myR = 0;
    // myC = 1;
    // System.out.println(myR + ", " + myC + " next gen: " + getNextGenCell(board,myR,myC)); // X
    // myR = 1;
    // myC = 0;
    // System.out.println(myR + ", " + myC + " next gen: " + getNextGenCell(board,myR,myC)); // X
    // myR = 1;
    // myC = 1;
    // System.out.println(myR + ", " + myC + " next gen: " + getNextGenCell(board,myR,myC)); // X
    // myR = 2;
    // myC = 2;
    // System.out.println(myR + ", " + myC + " next gen: " + getNextGenCell(board,myR,myC)); // -









    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");

    board = generateNextBoard(board);
    System.out.println("Gen X+2:");
    printBoard(board);
    System.out.println("--------------------------\n\n");

    board = generateNextBoard(board);
    System.out.println("Gen X+3:");
    printBoard(board);
    System.out.println("--------------------------\n\n");



    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
