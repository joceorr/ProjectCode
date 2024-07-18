/**
 *
 *
 * DONT TOUCH THIS PLEASE
 *
 *
 */

package Rendering;

import Util.Calculator;
import Util.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This is a pixel panel. Basically it is just the set of pixels we render to the screen, nothing crazy
 */

public class PixelPanel extends JPanel {

    private ArrayList<Pixel> pixels;
    private int width;
    private int height;
    private Calculator calc;

    /**
     * The constructor
     * @param w Number of pixels in the x direction
     * @param h Number of pixels in y direction
     * @param pixelWidth width of individual pixel
     * @param pixelHeight height of individual pixel
     */
    public PixelPanel(int w, int h, int pixelWidth, int pixelHeight){
        this.width = w;
        this.height = h;
        calc = new Calculator(width, height);
        pixels = new ArrayList();
        Pair currCoords;
        for(int i = 0; i < width*height; i++){
            currCoords = calc.coordFromIndex(i);
            pixels.add(new Pixel(currCoords.getX()*pixelWidth, currCoords.getY()*pixelHeight,pixelWidth, pixelHeight, 0));
        }
    }

    /**
     * A stupid required method that will draw stuff on the screen
     * @param g the graphic to draw on. Javax handles this
     */
    public void paintComponent(Graphics g){
        for(Pixel p : pixels){
            p.draw(g);
        }
    }

    /**
     * Returns a pixel from a give coord so it can be modified. Top left is (x,y) = (0,0)
     * @param x x coord
     * @param y y coord
     * @return the pixel
     */
    public Pixel getPixel(int x, int y){
        return pixels.get(x + (y * width));
    }

    /**
     * Return the number of pixels on the screen
     * @return read above
     */
    public int canvasSize(){
        return(width*height);
    }
}
