package Simulation;


import Util.Pair;

import java.util.ArrayList;

/**
 * A tissue cell. It wants to grow, but not as much as cancer. Has a chance to turn a dead
 * cell into a live one every time step
 */

public class TissueCell extends Cell{

    public TissueCell (int x, int y){
        super(0, x, y, 1);
    }

    @Override
    public void interactNeighbors (ArrayList<Cell> neighbors){

        ArrayList<DeadCell> deadCells = new ArrayList<DeadCell>( );

        // Checks neighborhood for any dead cells
        for (Cell neighborCell : neighbors){
            if (neighborCell instanceof DeadCell
                    && Math.abs(neighborCell.getX() - getX()) <= 1
                    && Math.abs(neighborCell.getY() - getY()) <= 1){

                deadCells.add((DeadCell) neighborCell);
            }
        }

        // If any dead cells exist, 70% chance it will pick one and grow into it
        if (deadCells.size( ) > 0){
            if (Math.random( ) < 0.70){

                // Pick a random neighbor dead cell
                int random = (int)(Math.random() * deadCells.size());
                DeadCell target = deadCells.get(random);

                // Replace dead cell with a tissue cell
                int index = neighbors.indexOf(target);
                neighbors.set(index, new TissueCell(target.getX(), target.getY()));
            }
        }
    }


    /**
     * The logic object expects a constructor that takes a coordinate stored as a pair
     * See the Util folder and Pair.java to learn about the implementation of this
     * @param coords
     */
    public TissueCell(Pair coords){
        super (0, coords.getX(), coords.getY(), 1);
    }

}
