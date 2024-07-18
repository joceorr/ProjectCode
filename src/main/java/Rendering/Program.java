/**
 *
 *
 * DONT TOUCH THIS PLEASE, UNLESS YOU WANT TO EDIT THE WIDTH / HEIGHT OF THE PROGRAM
 *
 *
 */

package Rendering;

import Simulation.Logic;
import Util.Calculator;
import Util.Pair;

import javax.swing.*;

/**
 * This handles the little window you see, and updating it every "frame"
 * You can edit this to change framerate if you would like
 */

public class Program {

    long timeSinceLastUpdate = 0;
    private final long FRAME_TIME = (long)((1.0/10.0)*1000000000.0); // set the denominator to desired frame rate (10 by default)

    private int width;
    private int height;

    /**
     * OPEN THE GAME
     * @param args
     */
    public static void main(String[] args){
        Program program = new Program();
    }

    /**
     * Default constructor, all it does is call the start method
     */
    public Program(){
        onUserStart();
    }

    /**
     * Initiliazes stuff rendiering an each pixel on the screen. You can modify
     * the width and height if you want, but this will increase sim time!
     */
    private void onUserStart(){
        // YOU CAN EDIT THESE
        width = 100;
        height = 100;
        //Tada
        Logic programLogic = new Logic(width, height);
        // You can mess with these but it might freak out
        int pixelWidth = 10;
        int pixelHeight = 10;
        // Ok you've had enough fun
        javax.swing.JFrame frame = new javax.swing.JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((width+2)*pixelWidth, (height+4)*pixelHeight);
        PixelPanel pixels = new PixelPanel(width, height, pixelWidth, pixelHeight);
        frame.getContentPane().add(pixels);
        frame.setVisible(true);
        pixels.repaint();
        long currTime = 0;
        long nextTime = 0;
        while(true){
            currTime = System.nanoTime();
            onUserUpdate(pixels, currTime - nextTime, programLogic);
            pixels.repaint();
            nextTime = currTime;
        }
    }

    /**
     * This runs every frame.
     * @param pixels the pixel panel for making graphics go burr
     * @param timeEllapsed time ellapsed since last frame
     * @param programLogic the Logic object that make all the logical stuff happen
     */
    private void onUserUpdate(PixelPanel pixels, long timeEllapsed, Logic programLogic){
        if(timeSinceLastUpdate < FRAME_TIME){
            timeSinceLastUpdate += timeEllapsed;
        } else {
            timeSinceLastUpdate = 0;
            Pair coords;
            programLogic.timeStep();
            for(int i = 0; i < pixels.canvasSize(); i++){
                coords = Calculator.coordFromIndex(i);
                pixels.getPixel(coords.getX(), coords.getY()).setColour(programLogic.setColour(coords));
            }
        }
    }
}
