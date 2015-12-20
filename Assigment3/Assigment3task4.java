/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment3task4;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.Color;

/**
 *
 * @author Bogdan Katrenko
 */
public class Assigment3task4 extends WindowProgram {
    /*
     Feeling yourself like a pharaon! Get your own piramide with this app. 
     set in constant how many bricks in base you want, and have enjoy.
    
     For solving task decomposition into 2 parts:
     1. Overriding GRect class for get my own bricks
     2. make two cycles for drawing piramide.
     */

    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;
    public static final int BRICK_HEIGHT = 15;
    public static final int BRICK_WIDTH = 30;
    public static final int BRICKS_IN_BASE = 10;

    public void run() {
        this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT); // resizing app to our const variables
        drawPiramide();
    }

    /*
     Drawing piramide in two cycles. 
     */
    private void drawPiramide() {

        int x = (getWidth() - BRICKS_IN_BASE * BRICK_WIDTH) / 2; // get first brick X coordinates
        int y = getHeight() - BRICK_HEIGHT; // get first brick Y coordinate

        for (int j = BRICKS_IN_BASE; j > 0; j--) {
            for (int i = j; i > 0; i--) {
                add(new CustomGRect(x, y, BRICK_WIDTH, BRICK_HEIGHT));
                x += BRICK_WIDTH;
            }
            x = ((getWidth() - BRICKS_IN_BASE * BRICK_WIDTH) / 2) + ((BRICK_WIDTH / 2) * ((BRICKS_IN_BASE + 1) - j));
            y -= BRICK_HEIGHT;
        }
    }

    public class CustomGRect extends GRect {

        public CustomGRect(double d, double d1, double d2, double d3) {
            super(d, d1, d2, d3);
            super.setColor(Color.BLACK);
            super.setFilled(true);
            super.setFillColor(Color.ORANGE);
        }
    }
}
