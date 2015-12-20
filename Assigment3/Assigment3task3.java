package assigment3task3;

import com.shpp.cs.a.console.TextProgram;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Bogdan Katrenko 
 * This program get you pow of entered variable!
 */
public class Assigment3task3 extends TextProgram {
    /*
     For solving task decomposition into 2 parts:
     1. Ask user for entering pow variable
     2. Using recursion for get pow
     */
    
    public static int ZERO = 0; // we need zero always
    public static double ONE = 1.0; // we need it for calculating pow
   
   
    public void run() {
        println("Pow is: " + getPow(readDouble("variable"), readInt("pow")));
    }

    /*
    @param value - we want to knowing pow of it
    @param pow - we want to see value in pow of it
    @return pow of input value
    */
    private double getPow(double value, int pow) {
    if(pow == ZERO) return ONE;
    if(pow < ZERO) return ONE / (value * getPow (1.0 / value, (int) (pow + ONE)));
    return value * getPow(value, (int) (pow - ONE));
    }


    
    /*
    Overriding readDouble() for checking user input
    */
    @Override
    public double readDouble(String text) {
        double entered = ZERO;
        boolean ok = false;

        while (!ok) {
            Scanner sc = new Scanner(System.in);

            try {
                print("Please, enter " + text + ": ");
                entered = sc.nextDouble();
                ok = true;
            } catch (InputMismatchException e) {
                println("Enter only variable, not other symbols.");
            }
        }
        return entered;
    }
    
    
    /*
    Overriding readInt() for checking user input
    */
    @Override
    public int readInt(String text) {
        int entered = ZERO;
        boolean ok = false;

        while (!ok) {
            Scanner sc = new Scanner(System.in);

            try {
                print("Please, enter " + text + ": ");
                entered = sc.nextInt();
                ok = true;
            } catch (InputMismatchException e) {
                println("Enter only variable, not other symbols.");
            }
        }
        return entered;
    }
    
}
