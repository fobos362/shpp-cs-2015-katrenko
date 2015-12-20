package illuzorconturs;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.Color;

/**
 * @author Bogdan Katrenko
 */
public class Assigment2task2 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;
    public static final int THREE = 3; // using this const for dividing window on three parts
    public static final int TWO = 2; // using this const for getting center of ovals
    public static final int NULL = 0; // it for set begin of coordinate system

    public void run() {
        this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT); // resizing app to our const variables
        drawIlluzorContours(getWidth() / THREE, getHeight() / THREE); // drawing illusion
    }

    /*
     Drawing figure of illusion
     */
    private void drawIlluzorContours(int radiusX, int radiusY) {
        add(new CustomGOval(NULL, NULL, radiusX, radiusY));
        add(new CustomGOval(getWidth() - radiusX, NULL, radiusX, radiusY));
        add(new CustomGOval(getWidth() - radiusX, getHeight() - radiusY, radiusX, radiusY));
        add(new CustomGOval(NULL, getHeight() - radiusY, radiusX, radiusY));
        add(new CustomGRect(radiusX / TWO, radiusY / TWO, radiusX * TWO, radiusY + (radiusY)));
    }

    /*
     Overriding GOval for set custom options 
     */
    public class CustomGOval extends GOval {

        public CustomGOval(double d, double d1, double d2, double d3) {
            super(d, d1, d2, d3);
            super.setFilled(true);
            super.setColor(Color.BLACK);
        }
    }

    /*
     Overriding GRect for set custom options 
     */
    public class CustomGRect extends GRect {

        public CustomGRect(double d, double d1, double d2, double d3) {
            super(d, d1, d2, d3);
            super.setFilled(true);
            super.setColor(Color.WHITE);
        }
    }
}
