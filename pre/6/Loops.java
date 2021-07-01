import java.util.Scanner;
import java.lang.Math;
import java.math.BigInteger;

public class Loops {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // System.out.println("17! is " + factorial(17));

        // System.out.println(myexp(3,10));
        // System.out.println(myexp2(3,10));

        // check(1);

        // Write a loop in main that invokes check with the values 0.1, 1.0, 10.0, and 100.0. How does the accuracy of the result vary as x varies? Compare the number of digits of agreement rather than the difference between the actual and estimated values.
        check(0.1);
        check(1.0);
        check(10.0);
        check(100.0);
        // For some reason, shows this:
        // 0.1     1.0                     1.1051709180756477
        // 1.0     2.7182818284590455      2.718281828459045
        // 10.0    10737.015608101345      22026.465794806718
        // 100.0   2.5702664928058498E7    2.6881171418161356E43

        // Add a loop in main that checks myexp with the values -0.1, -1.0, -10.0, and -100.0. Comment on the accuracy.

    }


    // Exercise 4  
    // Section 6.7 presents a recursive method that computes the factorial function. Write an iterative version of factorial.
    public static BigInteger factorial (int num) {
        // int result = 1;
        BigInteger result = BigInteger.ONE;

        for(int i = num; i > 1; i--) {
            // result *= i;
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }


    // Exercise 5  
    // One way to calculate e^x is to use the infinite series expansion:
    // e^x = 1 + x + x^2 / 2! + x^3 / 3! + x^4 / 4! + … 
    // The ith term in the series is x^i / i!.
    // Write a method called myexp that takes x and n as parameters and estimates e^x by adding the first n terms of this series. You can use the factorial method from Section 6.7 or your iterative version from the previous exercise.
    public static double myexp(double x, int n) {
        double result = 1;
        for(int i = 1; i < n; i++) {
            int numer = (int)Math.pow(x,i);
            // int denom = factorial(i);
            BigInteger denom = factorial(i);
            // double frac = numer/denom;
            double frac = numer / denom.doubleValue();
            result += frac;
            
            // System.out.print("i: " + i + "; ");
            // System.out.print(numer + "/");
            // System.out.print(denom + "=");
            // System.out.print(frac);
            // System.out.println(" + ");
        }
        return result;
    }
    
    // You can make this method more efficient if you realize that the numerator of each term is the same as its predecessor multiplied by x, and the denominator is the same as its predecessor multiplied by i. Use this observation to eliminate the use of Math.pow and factorial, and check that you get the same result.
    public static double myexp2(double x, int n) {
        double result = 1;
        int numer = 1;
        BigInteger denom = new BigInteger("1");
        for(int i = 1; i < n; i++) {
            numer *= x;
            denom = denom.multiply(BigInteger.valueOf(i));
            double frac = numer / denom.doubleValue();
            result += frac;

            // System.out.print("i: " + i + "; ");
            // System.out.print(numer + "/");
            // System.out.print(denom + "=");
            // System.out.print(frac);
            // System.out.println(" + ");
        }
        return result;
    }

    // Write a method called check that takes a parameter, x, and displays x, myexp(x), and Math.exp(x). The output should look something like:
    // 1.0     2.708333333333333     2.718281828459045
    // You can use the escape sequence "\\t" to put a tab character between columns of a table.
    // Vary the number of terms in the series (the second argument that check sends to myexp) and see the effect on the accuracy of the result. Adjust this value until the estimated value agrees with the correct answer when x is 1.
    public static void check(double x) {
        System.out.println(x + "\t" + myexp(x, 18) + "\t" + Math.exp(x));
    }
}