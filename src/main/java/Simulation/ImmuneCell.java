package Simulation;

import Util.Pair;

import java.util.ArrayList;

/**
 * The immune cell! It kills cancer, and has a chance to attack multiple cancer cells per turn!
 */

public class ImmuneCell extends Cell{

    public ImmuneCell (int x, int y) {
        super (3, x, y, 4);
    }

    @Override
    public void interactNeighbors (ArrayList<Cell> neighbors) {

        ArrayList<CancerCell> cancerCells = new ArrayList<CancerCell>( );

        // Checks neighborhood for cancer cells
        for (Cell neighborCell : neighbors) {
            if (neighborCell instanceof CancerCell
                    && Math.abs(neighborCell.getX() - getX()) <= 1
                    && Math.abs(neighborCell.getY() - getY()) <= 1) {

                cancerCells.add((CancerCell) neighborCell);
            }
        }

        // If there is a cancer cell choose one and replace it
        if (cancerCells.size() > 0) {

            // Pick a random neighbor cancer cell
            int random = (int)(Math.random() * cancerCells.size());
            CancerCell target = cancerCells.get(random);

            // Replace cancer cell with dead cell
            int index = neighbors.indexOf(target);
            neighbors.set(index, new DeadCell(target.getX(), target.getY()));
        }

    }
    /**
     * The logic object expects a constructor that takes a coordinate stored as a pair
     * See the Util folder and Pair.java to learn about the implementation of this
     * @param coords
     */
    public ImmuneCell(Pair coords){
        super(3, coords.getX(), coords.getY(), 4);
    }

}