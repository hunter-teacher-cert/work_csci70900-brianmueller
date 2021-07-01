import java.util.Scanner;
import java.lang.Math;

public class Craps {
    public static void main(String[] args) {

        System.out.println("\nWelcome to Craps! How many rounds would you like to play?");
        Scanner scan = new Scanner(System.in);
        int numOfRounds = scan.nextInt();
        System.out.println("");

        for(int i = 0; i < numOfRounds; i++){
            System.out.println("ROUND " + (i+1));
            System.out.println("Shooter " + round() + "s\n");
        }

    }

    // returns a random number between 1 and max, inclusive.
    public static int roll(int max) {
        return (int)(Math.random()*max+1);
    } 

    // returns the result of rolling dice
    public static int shoot(int numOfDice, int maxVal) {
        int result = 0;
        for(int i = 0; i < numOfDice; i++){
            result += roll(maxVal);
        }
        return result;
    }

    // returns "win" or "lose", prints details throughout
    public static String round() {
        int diceVal = shoot(2,6);
        System.out.println("Shooter rolled " + diceVal);
        if(diceVal == 2 || diceVal == 3 || diceVal == 12){
            System.out.println("Craps");
            return "lose";
        } else if(diceVal == 7 || diceVal == 11){
            System.out.println("Natural");
            return "win";
        } else {
            System.out.println("The point is " + diceVal);
            int point = diceVal;
            do {
                diceVal = shoot(2,6);
                System.out.println("Shooter rolled " + diceVal);
                if(diceVal == point){
                    System.out.println("Point");
                    return "win";
                } else if(diceVal == 7){
                    System.out.println("Craps");
                    return "lose";
                } 
            } while(diceVal != 7 || diceVal != point);
        }
        return "";
    }

}

