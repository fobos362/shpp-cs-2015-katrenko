/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment3task6;

/**
 * 
 * @author Bogdan Katrenko
 */
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.util.ArrayList;

public class Assigment3task6 extends WindowProgram {
     /*
     This simple animation try to helps you to relax and enjoy the beauty of nature. 
     You can see the sunset and 100 stars.
    
     For solving task decomposition into 2 parts:
     1. Make sky, make sun stars (and not for 7 days, but for 20 minutes, feeling like a God!)
     2. Animation all in cycle.
     */
    
    private static final double PAUSE_TIME = 1000.0 / 48; // for regular fps
    private static final double PLUSABLE_VALUE = 0.01; // this value is plusable to sun coordinate each turn
    private static final float GROUND_EDGE = 0.75f; // 1/4 of window have ground
    private static final float STAR_EDGE = 0.25f; // 3/4 of window have star
    
    private static final int NULL = 0; // we often use it in cicle
    private static final int TIME_OF_ANIM = 400; // how many frames we display
    private static final int STARS_COUNT = 100; // how many stars we will see
    private static final int SUN_SIZE = 100; // size of sun oval
    private static final int MAX_COLOR = 255; // max count of color part

    private static final int SUN_R = 200; // red part of sun color
    private static final int SUN_G = 170; // green part of sun color
    private static final int SUN_B = 30; // blue part of sun color

    private static final int STAR_R = 255; // red part of star color
    private static final int STAR_G = 222; // green part of star color
    private static final int STAR_B = 37; // blue part of star color

    private static final int SKY_R = 40; // red part of sky color
    private static final int SKY_G = 40; // green part of sky color
    private static final int SKY_B = 200; // blue part of sky color

    public void run() {
       AnimWorld(createSun(), createSky(), createStars(), createGround()); // make components of animation,and play it
    }

    /**
     * Creating sky.
     * @return GRect of sky.
     */
    private GRect createSky(){
        GRect sky = new GRect(NULL, NULL, getWidth() + 1, getHeight() + 1);
        sky.setFilled(true);
        sky.setColor(Color.BLUE);
        return sky;
    }   
    
     /**
     * Creating stars.
     * @return 100 GRects of stars.
     */
    private GRect[] createStars(){
    GRect[] stars = new GRect[STARS_COUNT];

        for (int i = NULL; i < STARS_COUNT; i++) {
            stars[i] = new GRect(RandomGenerator.getInstance().nextInt(getWidth()), RandomGenerator.getInstance().nextInt(getHeight() - (int) (getHeight() * STAR_EDGE)), 1, 1);
            stars[i].setFilled(true);
        }
        return stars;
    }
    
     /**
     * Creating sun.
     * @return GOval of sun.
     */
    private GOval createSun(){
    GOval sun = new GOval(NULL, NULL, SUN_SIZE, SUN_SIZE);
        sun.setFilled(true);
        sun.setColor(Color.YELLOW);
        return sun;
    }
    
     /**
     * Creating ground.
     * @return GRect of ground.
     */
    private GRect createGround(){
    GRect ground = new GRect(NULL, getHeight() * GROUND_EDGE, getWidth() + 1, getHeight());
        ground.setFilled(true);
        ground.setColor(Color.BLACK);
        return ground;
    }
    
     /**
     * Added all creating components
     */
    private void addAll(GOval sun, GRect sky, GRect[] stars, GRect ground){
    add(sky);
    for (GRect star:stars) add(star);
    add(sun);
    add(ground);
    }
    
    /*
    Get all omponents and make animation
    */
    private void AnimWorld(GOval sun, GRect sky, GRect[] stars, GRect ground) {
        addAll(sun, sky, stars, ground);
        
        double dy = NULL;
        double dx = NULL;

        int sun_g = SUN_G;
        int star_a = NULL;
        int sky_b = SKY_B;
        int x = NULL;

        while (true) {
            dx += PLUSABLE_VALUE;
            dy += PLUSABLE_VALUE;

            if (x % 2 == NULL) 
                if (sun_g > NULL && sky_b > NULL && star_a < MAX_COLOR) {
                    sun_g--;
                    sky_b--;
                    star_a++;
                }
            
            sun.move(dy, dx);
                                   
            sun.setColor(new Color(SUN_R, sun_g, SUN_B));
            sky.setColor(new Color(SKY_R, SKY_G, sky_b));
            for (GRect star : stars) 
                star.setColor(new Color(STAR_R, STAR_G, STAR_B, star_a));
            
            pause(PAUSE_TIME);
            x++;
            if (x > TIME_OF_ANIM) 
                return;
        }
    }

}
