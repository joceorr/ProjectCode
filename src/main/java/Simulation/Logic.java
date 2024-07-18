package Simulation;

import java.util.ArrayList;

import Util.Calculator;
import Util.Pair;

/**
 * This little bugger handles the creation of the cells on the board and the running of
 * their logica
 */

public class Logic {
    private int width; //number of cells in x dir
    private int height; //number of cells in y dir
    private ArrayList<Cell> cellList; //arraylist holding cells
    private Calculator calc; //helpful calculator

    /**
     * THE CONSTRUCTOR. Sets the instance variables up, and starts to intilize the boy
     * @param width
     * @param height
     */
    public Logic(int width, int height){
        this.width = width;
        this.height = height;
        this.calc = new Calculator(width, height);
        cellList = new ArrayList<>();
        initialize();
    }

    /**
     * Puts cells on the board.
     */
    private void initialize(){
        double rngNum =0;
        for(int i =0; i < width*height; i++){
            rngNum = Math.random()*100;
            if (rngNum < 90.0){
                cellList.add(new TissueCell(calc.coordFromIndex(i)));
            }
            else if (rngNum >= 90.0 && rngNum < 99.0){
                cellList.add(new ImmuneCell(calc.coordFromIndex(i)));
            } else {
                cellList.add(new CancerCell(calc.coordFromIndex(i)));
            }
        }
    }

    /**
     * Calls the interaction method on each cell in the list.
     */
    public void timeStep(){
        for(Cell c : cellList){
            c.interactNeighbors(cellList);
        }
    }

    public int setColour(Pair coords){
        int toRet = cellList.get(calc.indexFromCoord(coords)).getID();
        return toRet;
    }
}
