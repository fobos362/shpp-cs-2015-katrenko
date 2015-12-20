/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gusenica;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.Color;

/**
 *
 * @author Bogdan Katrenko
 */
public class Assigment2task6 extends WindowProgram {
    /*
     This app will draw 'caterpillar' in your window. 
    
     */

    public static final int APPLICATION_WIDTH = 400; // resize app to this width
    public static final int APPLICATION_HEIGHT = 200; // resize app to this height
    public static final int CATERPILLAR_SEGMENTS = 10; // set how many segments have drawing caterpillar
    public static final int BODY_SEGMENT_OFFSET = 20; // offset for segment

    public void run() {
        drawCaterpillar(getWidth(), getHeight(), CATERPILLAR_SEGMENTS); // drawing caterpillar in window
    }

    /*
     this method is drawing caterpillar in our woindow.
     @param width - set width of future caterpillar
     @param height - using for centering caterpillar
     @param segments useing for set how many segment caterpillar have
     */
    private void drawCaterpillar(int width, int height, int segments) {

        int radius = (width / segments);
        int x = 0;
        int y = (height - radius) / 2;
        int plusable = ((radius * 3) / segments);
        radius += plusable - (plusable / segments);

        for (int i = 0; i < segments; i++) {

            GOval oval = new GOval(x, y, radius, radius);
            oval.setFilled(true);
            oval.setColor(Color.GREEN);
            add(oval);

            GOval ovalStroke = new GOval(x, y, radius, radius);
            ovalStroke.setColor(Color.RED);
            add(ovalStroke);

            x += (radius - plusable);
            if (i % 2 == 0) {
                y += BODY_SEGMENT_OFFSET;
            } else {
                y -= BODY_SEGMENT_OFFSET;
            }
        }
    }
}
