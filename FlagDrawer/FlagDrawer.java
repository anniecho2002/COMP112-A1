/* Code for COMP-102-112 - 2021T1, Assignment 1
 * Name: Annie Cho
 * Username: choanni
 * ID: 300575457
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws various flags
 *
 * You can find lots of flag details (including the correct dimensions and colours)
 * from  http://www.crwflags.com/fotw/flags/    
 */

public class FlagDrawer{

    public static final double LEFT = 100;  // the left side of the flags
    public static final double TOP = 50;    // the top of the flags

    /**   CORE
     * Draw the flag of Belgium.
     * The flag has three vertical stripes;
     * The left is black, the middle is yellow, and the right is red.
     * The flag is 13/15 as high as it is wide (ratio 13:15).
     */
    public void drawBelgiumFlag(){
        UI.clearGraphics();
        UI.println("Belgium Flag");
        double width = UI.askDouble("How wide: ");
        UI.setColor(Color.black);
        UI.fillRect(LEFT,TOP, width/3, 0.8667*width);
        UI.setColor(Color.yellow);
        UI.fillRect(LEFT+width/3,TOP, width/3, 0.8667*width);
        UI.setColor(Color.red);
        UI.fillRect(LEFT+width*2/3,TOP, width/3, 0.8667*width);
    }

    /**   CORE
     *  The Red Cross flag consists of a white square with a red cross in the center
     *  The cross can be drawn as a horizontal rectangle and a vertical rectangle.
     */
    public void drawRedCrossFlag() {
        UI.println("Red Cross Flag: ");
        UI.clearGraphics();
        double size = UI.askDouble("How wide: ");
        UI.setColor(Color.white);
        UI.fillRect(LEFT,TOP, size, size);
        UI.setColor(Color.red);
        UI.fillRect(LEFT+size*0.2,TOP+size*0.4, size*0.2, size*0.2);
        UI.fillRect(LEFT+size*0.4,TOP+size*0.2, size*0.2, size*0.2);
        UI.fillRect(LEFT+size*0.6,TOP+size*0.4, size*0.2, size*0.2);
        UI.fillRect(LEFT+size*0.4,TOP+size*0.4, size*0.2, size*0.2);
        UI.fillRect(LEFT+size*0.4,TOP+size*0.6, size*0.2, size*0.2);
    }

    /**   COMPLETION
     *  Pacman
     *  A red pacman facing up on a black background chasing yellow, green, and blue dots.
     *  
     */
    public  void drawPacman() {
        UI.clearGraphics();        
        UI.println("Pacman Flag");
        double width = UI.askDouble("How wide: ");
        double height = width*3/2;
        UI.setColor(Color.black);
        UI.fillRect(LEFT, TOP, width, height);
        UI.setColor(Color.yellow);
        UI.fillOval(LEFT+width*3/7, TOP+height*11/24, width*1/8,width*1/8);
        UI.setColor(Color.green);
        UI.fillOval(LEFT+width*3/7, TOP+height*7/24, width*1/8,width*1/8);
        UI.setColor(Color.blue);
        UI.fillOval(LEFT+width*3/7, TOP+height*3/24, width*1/7,width*1/8);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+width*1/4, TOP+height*13/24, width*1/2, width*1/2, 120, 300);

    }

    /**   COMPLETION
     * Draw the flag of Greenland.
     * The top half of the flag is white, and the bottom half is red.
     * There is a circle in the middle (off-set to left)  which is
     * also half white/red but on the opposite sides.
     * The flag is 2/3 as high as it is wide (ratio 2:3).
     * UI.fillOval(LEFT+width*1/7, TOP+height*1/6, height*2/3, height*2/3);
     */
    public void drawGreenlandFlag() {
        UI.clearGraphics();
        UI.println("Greenland Flag");
        double width = UI.askDouble("How wide: ");
        double height = width*2/3;
        UI.setColor(Color.white);
        UI.fillRect(LEFT, TOP, width, height/2);
        UI.setColor(Color.red);
        UI.fillRect(LEFT, TOP+height/2, width, height/2);
        UI.setColor(Color.white);
        UI.fillArc(LEFT+width*1/7, TOP+height*1/6, height*2/3, height*2/3, 180, 180);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+width*1/7, TOP+height*1/6, height*2/3, height*2/3, -180, -180);

    }

    /**   CHALLENGE
     * Draw the Koru Flag.
     * It was one of the new flag designs for the 2016 referendum,
     * designed by Sven Baker from Wellington
     * The flag is 1/2 as high as it is wide (ratio 1:2).
     */
    public void drawKoruFlag() {
        UI.clearGraphics();
        UI.println("Koru Flag");
        double width = UI.askDouble("How wide: ");
        double height = width/2;
        UI.setColor(Color.red);
        UI.fillRect(LEFT, TOP, width/2, height);
        UI.setColor(Color.blue.darker());
        UI.fillRect(LEFT+width/2, TOP, width/2, height);
        UI.setColor(Color.white);
        UI.fillOval(LEFT+width/5, TOP-(height*5/TOP), height*1.2, height*1.2);
        UI.setColor(Color.blue.darker());
        UI.fillOval(LEFT+(width*4/14), TOP+(height/11), height*0.85, height*0.85);
        UI.fillArc(LEFT+width*35/56, TOP+height/3, height*2/5, height*2/5, 180, 170);
        UI.setColor(Color.white);
        UI.fillOval(LEFT+width*71/112, TOP+height/3, height/3, height/3);

    }

    /**   CHALLENGE
     * Draw the flag of Samoa,
     * The flag is 1/2 as high as it is wide (ratio 1:2).
     * A red field with the blue rectangle on the top left quadrant bearing the Southern Cross
     *    of four white larger five-pointed stars and the smaller star in the center.
     * A full marks solution will have a method for drawing a 5 pointed star,
     * and call that method for each of the stars
     */
    public void drawStar(double size, double move_x, double move_y, double width){
        UI.setColor(Color.white);
        double a = width/size*16/288;
        double b = move_x;
        double c = move_y;
        double[] x  = {20*a+b,31*a+b,68*a+b,38*a+b,50*a+b,20*a+b,0*a+b,2*a+b,-28*a+b,9*a+b}; // x coordinates of star * size + value to move it
        double[] y = {-30*a+c,4*a+c,4*a+c,26*a+c,61*a+c,38*a+c,61*a+c,26*a+c,4*a+c,4*a+c}; // y coordinates of star * size + value to move it
        UI.fillPolygon(x, y, 10); //takes x and y coordinates in the array, star has 10 indices
    }
    
    public void drawSamoaFlag() {
        UI.clearGraphics();        
        UI.println("Samoa Flag");
        double width = UI.askDouble("How wide: ");
        double height = width/2;
        double size = 100; //width of the star
        double small_size = 160;
        double large_size = 80;
        double x1 = LEFT+width*42/288;
        double y1 = TOP+height*26/144;
        double x2 = LEFT+width*64/288;
        double y2 = TOP+height*10/144;
        double x3 = LEFT+width*87/288;
        double y3 = TOP+height*23/144;
        double x4 = LEFT+width*65/288;
        double y4 = TOP+height*55/144;
        double x5 = LEFT+width*78/288;
        double y5 = TOP+height*40/144;
        
        UI.setColor(Color.red);
        UI.fillRect(LEFT, TOP, width, height); // forming basic flag
        UI.setColor(Color.blue.darker());
        UI.fillRect(LEFT,TOP, width/2, height/2);
        drawStar(size, x1, y1, width); //calling on drawstar function for first star
        drawStar(size, x2, y2, width);
        drawStar(size, x3, y3, width);
        drawStar(large_size, x4, y4, width);
        drawStar(small_size, x5, y5, width);

    }


    public void setupGUI(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Core: Flag of Belgium", this::drawBelgiumFlag);
        UI.addButton("Core: Red Cross Flag",  this::drawRedCrossFlag);
        // COMPLETION
        UI.addButton("Completion: Pacman Flag", this::drawPacman);
        UI.addButton("Completion: Flag of Greenland", this::drawGreenlandFlag);
        // CHALLENGE
        UI.addButton("Challenge: Koru flag", this::drawKoruFlag);
        UI.addButton("Challenge: Flag of Samoa", this::drawSamoaFlag);
        UI.addButton("Quit", UI::quit);

        UI.setDivider(0.3);
    }

    public static void main(String[] arguments){
        FlagDrawer fd = new FlagDrawer();
        fd.setupGUI();
    }

}
