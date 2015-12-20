/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment3task2;

import com.shpp.cs.a.console.TextProgram;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Bogdan Katrenko This program will tell you about power of StromValue!
 */
public class Assigment3task2 extends TextProgram {
    /*
     For solving task decomposition into 2 parts:
     1. Ask user for entering StormVariable
     2. Using recursion for get all storm values
     */
    
    public static int TWO = 2; // constant for cheking values for even
    public static int THREE = 3; // constant for get 3n + 1
    public static int ONE = 1; // constant for get 3n + 1
    public static int ZERO = 0; // we need zero always
   
   
    public void run() {
        getStormValue(readInt("variable"));
    }

    /*
    @param value - the seed from which the calculation starts
    this method get all storm values from 'start value' to 'one'
    */
    private void getStormValue(int value) {
        if (value > 1) {
            if (value % TWO == ZERO) 
                println(value + " - value is even, so I take half: " + (value /= TWO));
             else 
                println(value + " - value is odd, so I make 3n + 1: " + (value = value * THREE + ONE));
        } else 
            return;
        getStormValue(value);
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
