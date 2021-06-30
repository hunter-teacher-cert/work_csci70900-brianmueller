/*
Programming in a High Level Language
In Class assignment - 6/30/21
Mancala
by
Liam Baum
Victoria Berkowitz
Brian Mueller
*/

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class Mancala{

  // initialize players mancala and arrays
  public static int aiMancala = 0;
  public static int playerMancala = 0;
  public static int[] aiPits = new int[] {4, 4, 4, 4, 4, 4};
  public static int[] playerPits = new int[] {15, 4, 4, 4, 4, 4};
  public static Scanner scan = new Scanner(System.in);
  public static Random rand = new Random();

  public static void showBoard() {
    // ai
    System.out.print(aiMancala + " ");
    for(int i = 0; i < 6; i++) {
      System.out.print(aiPits[i] + " ");
    }
    System.out.print("\n");

    // player
    System.out.print("  ");
    for(int i = 0; i < 6; i++) {
      System.out.print(playerPits[i] + " ");
    }
    System.out.println(playerMancala);
  }

  // checks to see if pit is empty
  public static boolean checkPitEmpty(int index, int[] pitArr){
    return pitArr[index] == 0;
  }

  // for when game is over
  public static boolean allPitsEmpty(int[] pitArr) {
    boolean noStones = true;
    for(int i = 0; i < 6; i++) {
      if(pitArr[i] > 0) {
        noStones = false;
      }
    }
    return noStones;
  }

  // sample gameboard
  /*
INDEX:     0 1 2 3 4 5
  AI:    0 4 4 4 4 4 4
  USER:    4 4 4 4 4 4 0
INDEX:     0 1 2 3 4 5

  */

  // public static int checkStonesInPit(int index, boolean user){
  //   if(user){
  //     return playerPits[startIndex];
  //   }else{
  //     return aiPits[startIndex];
  //   }
  // }

  //player right(their turn) index <5 - keep distributing
  //player right(their turn) index ==5 - add 1 to mancala and switch
  //player left(switched) index > 0 - keep distributing
  //player left(switched) index ==0 - add 1 to mancala and switch

  public static void playerTurn() {
    int currentIndex;
    System.out.print("Which pit would you like to choose from?\n");
    currentIndex = scan.nextInt();
    while(checkPitEmpty(currentIndex, playerPits)) { // should also make sure choice is btwn 1-6
      System.out.println("That pit is empty. Please choose another pit");
      System.out.print("Which pit would you like to choose from?\n");
      currentIndex = scan.nextInt();
    }
    currentIndex -= 1; // offset for 0-based indexing (pit 1 is index 0)
    int stonesInHand = playerPits[currentIndex]; // stores # of stones in new variable
    playerPits[currentIndex] = 0; // empties array index of chosen pit
    int direction = 1; // 1 = right, -1 = left
    int chosenStones = stonesInHand; // copy this value so it doesn't change the limit of the loop below
    for(int i = 0; i < chosenStones; i++) { // sets loop for number of stones chosen
      currentIndex += direction;

      if(currentIndex == 6){ // reached player Mancala
        stonesInHand--; // transfer from hand...
        playerMancala++; // ...to player mancala
        System.out.println("Stone added to player mancala!. Stones in Hand = " + stonesInHand); //debug check
        direction = -1; // set direction variable to opposite direction
      } else if(currentIndex == -1) { // reached aiMancala
        //skip ai Mancala
        System.out.println("Stones in Hand pre direction change = " + stonesInHand); // debug check
        direction = 1; // set direction variable to opposite direction
        System.out.println("Stones in Hand post direction change= " + stonesInHand); // debug check
        i--; // prevents accounting for one of the chosenStones loop iterations
      } else { // distribute stones
        if(direction == 1) { // player's pits
          stonesInHand--; // transfer from hand...
          playerPits[currentIndex]++; // ...to player pit
        } else { // ai's pits
          stonesInHand--; // transfer from hand...
          aiPits[currentIndex]++; // ...to ai pit
        }
      }
    }
      System.out.println("Stones in Hand end of turn= " + stonesInHand); // debug check
      // issue is there is still one stone left in hand
      // this is because the last thing that happens is currentIndex increments
      // but the last thing that should happen is stoneInHand--
      // maybe if sonesInHand == 1, stoneInHand-- then break
      // or for loop i < chosenStones + 1, since currentIndex is irrelevant after end of turn
  }



  public static void main(String[] args) {
    showBoard();
    // System.out.println(checkPitEmpty(0, aiPits));
    // System.out.println(checkPitEmpty(3, playerPits));
    //
    // System.out.println(allPitsEmpty(aiPits));
    // System.out.println(allPitsEmpty(playerPits));
    playerTurn();
    showBoard();
  }

}





// set up
// two arrays - player and opponant rows of pits -check
// two variables - player and opponant mancala - check
// user array on bottom / ai on top (visually)

//turn
// which index you will pick from
// how many stones in that index (pit)
// which direction will you traverse the array
// (user - up in index, ai down in index)
// add 1 to each following index  (use for loop)
// when you reach end or beginning of array, add one to mancala variables

//aiTurn
// choose random index btwn 0-5
// check that pit has stones in it (index != 0)


// moving stones method
// start on chosen index? is index > 0?
// checks whos turn?
   // If player move up, if ai move down
   // put stone in correct mancala


//checks

// did last stone go in mancala? repeat player turn
// are you in your own pits (array) &&  did last stone go in empty pit?
      // If opponents mirrored pit > 0?, move all stones from both indecies
// is either array empty? if so game over - check
