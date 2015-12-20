/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment3task1;

import com.shpp.cs.a.console.TextProgram;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Bogdan Katrenko
 *
 */
public class Assigment3task1 extends TextProgram {
    /*
     This app will telling you about your health. 
     Task decomposition into 2 parts:
     1. Ask user how many minutes for day he have sport
     2. Get result with simple calculations
     */

    public static int DAYS_OF_SPORT = 7; // set how many days user have sport
    public static int MINUTES_FOR_DAY_CARDI = 30; // set how many minutes need to good cardiovacular health
    public static int MINUTES_FOR_DAY_PRES = 40; // set how many minutes need to good pressure health

    public static int GOOD_RESULT_FOR_CARDI = 210; // how many minutes for 7 days need for good cardiovacular health 
    public static int GOOD_RESULT_FOR_PRESSURE = 120; // how many minutes for 3 days need for good pressure health

    public void run() {
        int min = askUser();
        println(getCardiovularResult(min) > 0 ? "Cardiovacular health:\n "
                + "You needed to train hard for at least " + getCardiovularResult(min) + " more day(s) a week!" : "Great job! You've done enough exercise for cardiovacular health. ");

        println(getBloodPresureResult(min) > 0 ? "Blood pressure:\n "
                + "You needed to train hard for at least " + getBloodPresureResult(min) + " more day(s) a week!" : "Great job! You've done enough exercise for blood presure health. ");
    }

    /*
     This method use our overriding version of readInt(), and get from user input 7 integer values, 
     that tell about how many minutes for day user have sport
     @return user input integer value
     */
    private int askUser() {
        int result = 0;
        for (int i = 1; i < DAYS_OF_SPORT + 1; i++) {
            result += readInt("How many minutes did you do on day " + i + "?");
        }
        return result;
    }

    /*
     @param minutes - it's sum of minutes for 7 days of sport
     @return how many user need to good cardiovacular health
     */
    private int getCardiovularResult(int minutes) {
        return GOOD_RESULT_FOR_CARDI - minutes < 0 ? 0 : (GOOD_RESULT_FOR_CARDI - minutes) / MINUTES_FOR_DAY_CARDI;
    }

    /*
     @param minutes - it's sum of minutes for 7 days of sport
     @return how many user need to good pressure health
     */
    private int getBloodPresureResult(int minutes) {
        return GOOD_RESULT_FOR_PRESSURE - minutes < 0 ? 0 : (GOOD_RESULT_FOR_PRESSURE - minutes) / MINUTES_FOR_DAY_PRES;
    }

    @Override
    public int readInt(String text) {
        int entered = 0;
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
