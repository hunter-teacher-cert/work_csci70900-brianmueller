import java.util.Scanner;
import java.lang.Math;

public class Arrays {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Exercise 1.1
        int[] myNums = {2,3,4};
        int[] myNumsSquared = powArray(myNums,2);
        // for(int i = 0; i < myNumsSquared.length; i++){
        //     System.out.println(myNumsSquared[i]);
        // }

        // Exercise 1.2
        int[] myScores = {0,0,0,1,1,2};
        int[] myScoresHisto = histogram(myScores, 3);
        // for(int i = 0; i < myScoresHisto.length; i++){
        //     System.out.println(myScoresHisto[i]);
        // }

        // Exercise 5
        boolean[] myPrimes = sieve(100);
        for(int i = 0; i < myPrimes.length; i++){
            System.out.println(i + ": " + myPrimes[i]);
        }
    }


    // Exercise 1   The goal of this exercise is to practice encapsulation with some of the examples in this chapter.
    
    // Starting with the code in Section 8.6, write a method called powArray that takes a double array, a, and returns a new array that contains the elements of a squared. Generalize it to take a second argument and raise the elements of a to the given power.
    public static int[] powArray(int[] nums, int exp){
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            result[i] = (int) Math.pow(nums[i], exp);
        }
        return result;
    }

    // Starting with the code in Section 8.10, write a method called histogram that takes an int array of scores from 0 to (but not including) 100, and returns a histogram of 100 counters. Generalize it to take the number of counters as an argument.
    public static int[] histogram(int[] scores, int numCounters){
        int[] histo = new int[numCounters];
        for(int i = 0; i < scores.length; i++){
            histo[scores[i]]++;
        }
        return histo;
    }


    // Exercise 5   The Sieve of Eratosthenes is “a simple, ancient algorithm for finding all prime numbers up to any given limit,” which you can read about at https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes.
    // Write a method called sieve that takes an integer parameter, n, and returns a boolean array that indicates, for each number from 0 to n - 1, whether the number is prime.
    public static boolean[] sieve(int limit){
        boolean[] primes = new boolean[limit];
        for(int i = 0; i < limit; i++){
            primes[i] = true; // assume all true
        }
        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i < limit; i++){
            for(int j = i+1; j < limit; j++){
                if(j % i == 0){
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}