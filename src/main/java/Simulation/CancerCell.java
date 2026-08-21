package Simulation;


import Util.Pair;

import java.util.ArrayList;

/**
 *This is a cancer cell. It is the most complex cell as it can attack tissue or immune cells, or grow into a dead cell.
 * For attacking tissue, it is a 1 hit replace it with a dead cell.
 * Immune cells are cooler. Each hit from a cancer cell lowers its strength by 1. When an immune cell reaches 0 strength
 * it dies!
 *
 * It has a priority of action. If it can grow, it will grow. If it can kill a tissue cell, it will do that. Why?
 * Easiest way to grow is to kill a week tissue cell. If no other option, will attack immune cells. Path of
 * least resistance to growing basically.
 *
 * Growing means turning a dead cell into a CancerCell.
 */

public class CancerCell extends Cell {

    public CancerCell (int x, int y){

        super (1, x, y, 3);
    }

    @Override
    public void interactNeighbors (ArrayList<Cell> neighbors) {

        // Find neighbor dead cells, tissue cells, and immune cells
        ArrayList<DeadCell> deadCells = new ArrayList<DeadCell>( );
        ArrayList<TissueCell> tissueCells = new ArrayList<TissueCell>( );
        ArrayList<ImmuneCell> immuneCells = new ArrayList<ImmuneCell>( );

        for (Cell neighborCell : neighbors) {
            if (neighborCell instanceof DeadCell
                    && Math.abs(neighborCell.getX() - getX()) <= 1
                    && Math.abs(neighborCell.getY() - getY()) <= 1) {

                deadCells.add((DeadCell) neighborCell);
            }

            if (neighborCell instanceof TissueCell
                    && Math.abs(neighborCell.getX() - getX()) <= 1
                    && Math.abs(neighborCell.getY() - getY()) <= 1) {

                tissueCells.add((TissueCell) neighborCell);
            }

            if (neighborCell instanceof ImmuneCell
                    && Math.abs(neighborCell.getX() - getX()) <= 1
                    && Math.abs(neighborCell.getY() - getY()) <= 1) {

                immuneCells.add((ImmuneCell) neighborCell);
            }
        }

        // If any dead cells exist immediately grow into first one
        if (deadCells.size( ) > 0){

            int random = (int)(Math.random() * deadCells.size());
            DeadCell target = deadCells.get(random);

            int index = neighbors.indexOf(target);
            neighbors.set(index, new CancerCell(target.getX(), target.getY()));
        }

        // If more tissue cells than immune cells replace tissue cell with dead cell
        else if (tissueCells.size() > immuneCells.size() && tissueCells.size() > 0) {

            int random = (int)(Math.random() * tissueCells.size());
            TissueCell target = tissueCells.get(random);

            int index = neighbors.indexOf(target);
            neighbors.set(index, new DeadCell(target.getX(), target.getY()));
        }

        // If there are immune cells attack one
        else if (immuneCells.size() > 0) {

            int random = (int)(Math.random() * immuneCells.size());
            ImmuneCell target = immuneCells.get(random);

            // Lower strength by 1
            target.setStrength(target.getStrength() - 1);

            // Strength lowered to 0, replaced by dead cell
            if (target.getStrength() <= 0) {
                int index = neighbors.indexOf(target);
                neighbors.set(index, new DeadCell(target.getX(), target.getY()));
            }
        }
    }

    public CancerCell(Pair coords){
        super(1, coords.getX(), coords.getY(), 3);
    }
}
