/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubillusion;

import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.Color;
import java.util.LinkedList;

/**
 *
 * @author Shpp
 */
public class Assigment2task5 extends WindowProgram {

    public static final int APPLICATION_WIDTH = 500;
    public static final int APPLICATION_HEIGHT = 500;

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /*getting white rows betweenfigures for centering our illusion */
    private static final int WHITE_ROWS = 4;

    /*dividing by two for centering*/
    private static final int TWO = 2;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    private LinkedList<ColorGRect> mRectList;

    public void run() {
        mRectList = new LinkedList();

        this.resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);

        drawCell(10, 10, 500, 500, 30, 10, 10, 10);

        while (true) {
            for (int i = 0; i < mRectList.size(); i++) {
                mRectList.get(i).setColor(RandomGenerator.getInstance().nextColor());
                this.repaint();
            }

        }
    }

    private void drawCell(int x, int y, int input_width, int input_height, int box_size, int box_spasing, int num_rows, int num_cols) {

        int borned_x = x;

        for (int i = 0; i < num_rows; i++) {
            for (int j = 0; j < num_cols; j++) {

                ColorGRect c = new ColorGRect(x, y, box_size, box_size, Color.BLACK);
                add(c);
                mRectList.add(c);
                x += box_size + box_spasing;
            }
            x = borned_x;
            y += box_size + box_spasing;
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
