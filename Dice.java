package Project02;

import Project02.Nation;
import Project02.People;
import java.util.*;

/**
 * This class is a dice class where it is random generated to be used within into the Artifacts in the game.
 */
public class Dice {
    private int side;

    /**
     * This method is making sure  that all sides of the dice is being used.
     * @param s
     */
    public Dice(int s){
        this.side = s;
    }

    /**
     * This method is used once the dice is rolled, we know that dice is rolled randomly.
     * @return side
     */
    public int roll(){
        Random random = new Random();
        side = random.nextInt(6) +1;
        return side;
    }
}
