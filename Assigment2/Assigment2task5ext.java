/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment2task5ext;

import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.Color;
import java.util.LinkedList;

/**
 *
 * @author Shpp
 */
public class Assigment2task5ext extends WindowProgram {

    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 600;

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 15;
    private static final int NUM_COLS = 15;

    /*getting white rows betweenfigures for centering our illusion */
    private static final int WHITE_ROWS = 4;

    /*dividing by two for centering*/
    private static final int TWO = 2;

    /* The width and height of each box. */
    private static final int BOX_SIZE = 20;

    /* The horizontal and vertical spacing between the boxes. */
    private static final int BOX_SPACING = 10;

    private ColorGRect[][] mRectList;

    public void run() {
        mRectList = new ColorGRect[NUM_ROWS][NUM_COLS];
        this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        drawCell(((getWidth() - ((BOX_SIZE + BOX_SPACING) * NUM_COLS)) / 2), ((getHeight() - ((BOX_SIZE + BOX_SPACING) * NUM_ROWS)) / 2), APPLICATION_WIDTH, APPLICATION_HEIGHT, BOX_SIZE, BOX_SPACING, NUM_ROWS, NUM_COLS);
        makeDisko();
    }

    /*
    This method draw rect matrix on your window
    @param x - left top of matrix edge on X coordinate
    @param y - left top of matrix edge on Y coordinate
    @param input_width - width of app's window
    @param input_height - height of app's window
    @param box_size - size of rect in matrix
    @param box_spacing - spacng between two rect in matrix
    @param num_rows - how many rows we want to see
    @param num_cols - how many cols we want to see
    */
    private void drawCell(int x, int y, int input_width, int input_height, int box_size, int box_spacing, int num_rows, int num_cols) {

        int borned_x = x;

        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {

                mRectList[i][j] = new ColorGRect(x, y, box_size, box_size, Color.BLACK);
                add(mRectList[i][j]);

                x += box_size + box_spacing;
            }
            x = borned_x;
            y += box_size + box_spacing;
        }
    }

    private void makeDisko() {
        while (true) 
            for (int i = 0; i < NUM_ROWS; i++) 
                for (int j = 0; j < NUM_COLS; j++) {
                    mRectList[i][j].setColor(RandomGenerator.getInstance().nextColor());
                    this.repaint();
                }
    }

    public class ColorGRect extends GRect {

        public ColorGRect(double d, double d1, double d2, double d3, Color color) {
            super(d, d1, d2, d3);
            super.setFilled(true);
            super.setColor(color);
        }
    }

}
