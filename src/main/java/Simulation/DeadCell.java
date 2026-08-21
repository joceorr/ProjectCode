package Simulation;


import Util.Pair;

/**
 * This cell is dead and does nothing
 */
public class DeadCell extends Cell{

    public DeadCell (int x, int y){
        super(0, x, y, 0);
    }

    /**
     * The logic object expects a constructor that takes a coordinate stored as a pair
     * See the Util folder and Pair.java to learn about the implementation of this
     * @param coords
     */
    public DeadCell(Pair coords){
        super(0, coords.getX(), coords.getY(), 0);
    }

}
