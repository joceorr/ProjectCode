package Simulation;


import java.util.ArrayList;

/**
 * The default, boring cell.
 */

public class Cell {

    private int strength;
    private int x;
    private int y;
    private int id;

    // Getters and Setters
    public void setStrength(int strength){
        if (strength >= 0){
            this.strength = strength;
        } else {
            this.strength = 0;
        }
    }

    public int getStrength(){
        return this.strength;
    }

    public void setX (int x){
        if (x >= 0){
            this.x = x;
        } else {
            this.x = 0;
        }
    }

    public int getX(){
        return this.x;
    }

    public void setY (int y){
        if (y >= 0){
            this.y = y;
        } else {
            this.y = 0;
        }
    }

    public int getY(){
        return this.y;
    }

    public void setID (int id){
        if (id >= 0){
            this.id = id;
        } else {
            this.id = 0;
        }
    }

    public int getID(){
        return this.id;
    }

    // Default constructor
    public Cell () {
        strength = 0;
        x = 0;
        y = 0;
        id = 0;
    }

    // Constructor with parameters
    public Cell (int strength, int x, int y, int id) {
        this.strength = strength;
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public void interactNeighbors(ArrayList<Cell> neighbors){

    }

    /**
     * the simulation expects a getter that return the ID that is specifically called getID()
     * any other method call will break it. So if you name this "getCellID()" or "getId()" it won't work
     * This is why interfaces are useful
     * @return
     */

}
