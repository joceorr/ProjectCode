/**
 *
 *
 * DONT TOUCH THIS PLEASE
 *
 *
 */

package Util;

/**
 * Another utility. It stores two ints. Useful for 2D coordinates! I left stuff public here cause it is
 * a bit silly to have getters and setters.
 */
public class Pair {
    private int x; // x pos
    private int y; //y pos

    /**
     * Constructors
     * @param x x pos
     * @param y y pos
     */
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Default constructor that sets (x,y) = (0,0);
     */
    public Pair(){
        this(0,0);
    }

    /**
     * Gives x coord
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * give y coord
     * @return y
     */
    public int getY() {
        return y;
    }

}
