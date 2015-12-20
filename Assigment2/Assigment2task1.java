package firstprogram;

/**
 * @author Bogdan Katrenko The program will help you to solve a quadratic
 * equation You may enter three variables, and getting roots of equation Enjoy!
 */
import com.shpp.cs.a.console.TextProgram;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assigment2task1 extends TextProgram {

    private final static int TWO = 2; // D = >>>b2<<< - 4ac | we need b^2, and use this constant in pow() function 
    private final static int FOUR = 4; // D = b2 - >>>4<<< ac | 4 - it's part of formula 
    private final static int NULL = 0; // this two variables - NULL and ONE use int getRoot() for knowing  
    private final static int ONE = 1;  //   "-" or "+" we need. We may using one method for getting two roots.    
   /*
     Start out application there
     */

    public void run() {
        solveQuadraticEquation(readDouble("a"), readDouble("b"), readDouble("c"));
    }

    /*
     This method is getting three variable, and find root of equation
     and using findDiscriminant() and getRoot()
     */
    private void solveQuadraticEquation(double a, double b, double c) {
        double discriminant = findDiscriminant(a, b, c);
        if (discriminant < NULL) {
            println("There are no real roots\n");
        } else {
            println(discriminant == NULL ? String.format("There are one root: %.1f\n", getRoot(discriminant, a, b, ONE))
                    : String.format("There are two roots: %.1f and %.1f\n", getRoot(discriminant, a, b, ONE), getRoot(discriminant, a, b, NULL)));
        }
    }

    /*
     Find discriminant for formulaa D = b2 - 4ac
     */
    private double findDiscriminant(double a, double b, double c) {
        return Math.pow(b, TWO) - (FOUR * a * c) < NULL ? -1.0 : Math.sqrt(Math.pow(b, TWO) - (FOUR * a * c));
    }

    /*
     Find root for formula    -b +||- sqrt(d) / 2*a
     */
    private double getRoot(double discriminant, double a, double b, int p) {
        return p > 0 ? (b + discriminant) / (TWO * a) : (b - discriminant) / (TWO * a);
    }

    // Overriding read double for checking users input data 
    @Override
    public double readDouble(String name) {
        double entered = 0;
        boolean ok = false;

        while (!ok) {
            Scanner sc = new Scanner(System.in);

            try {
                print("Please, enter " + name + ": ");
                entered = sc.nextDouble();
                ok = true;
            } catch (InputMismatchException e) {
                println("Enter only variable, not other symbols.");
            }
        }
        return entered;
    }
}
