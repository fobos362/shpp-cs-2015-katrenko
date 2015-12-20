package flags;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.Color;

/**
 *
 * @author Bogdan Katrenko
 */
public class Assigment2task4 extends WindowProgram {
    /*
     This program is drawing flag in center of window.
     Task decomposition into 3 parts:
     * 1. overriding GRect for get custom filled and color red 
     * 2. drawing flag with three custom rect
     * 3. drawing label
     */

    public static final String LABEL_TEXT = "Flag of my Kingdom!"; // label for flags

    public static final int APPLICATION_WIDTH = 500; // we are resize app window to this width
    public static final int APPLICATION_HEIGHT = 500; // we are resize app window to this height

    public static final int FLAG_WIDTH = 300; // this constant get width for painting flag
    public static final int FLAG_HEIGHT = 170; // this constant get width for painting flag

    public static final int TWO = 2; // this constant using for centering figures
    public static final int THREE = 3; // this constant for drawing lines of flag

    public void run() {
        this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT); // resize app with constants
        drawFlag((getWidth() - FLAG_WIDTH) / TWO, (getHeight() - FLAG_HEIGHT) / TWO, FLAG_WIDTH, FLAG_HEIGHT); // draw flag 
        drawLabel(LABEL_TEXT); // draw label   
    }

    /*
     @param x - there is x-coordinate of flag
     @param y - there is y-coordinate of flag
     @param width - get width of flag
     @param height - get height of flag
     */
    private void drawFlag(int x, int y, int width, int height) {
        add(new ColorGRect(x, y, width / THREE, height, Color.BLACK));
        add(new ColorGRect(x + width / THREE, y, width / THREE, height, Color.RED));
        add(new ColorGRect(x + ((width / THREE) * TWO), y, width / THREE, height, Color.YELLOW));
    }

    /*
     Set text of label to s, and method set text label in right && bottom corner of window
     */
    private void drawLabel(String s) {
        GLabel label = new GLabel(s);
        label.setLocation(getWidth() - label.getWidth(), (getHeight() - label.getHeight()) + label.getFontMetrics().getMaxAscent());
        add(label);
    }

    /*
     Overriding class GRect like we need.
     set it filled and coloring (@param color)
     */
    public class ColorGRect extends GRect {

        public ColorGRect(double d, double d1, double d2, double d3, Color color) {
            super(d, d1, d2, d3);
            super.setFilled(true);
            super.setColor(color);
        }
    }
}
