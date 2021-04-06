package Project02;

import Project02.Nation;
import Project02.People;
import java.util.*;


public class Dice {
    private int side;

    public Dice(int s){
        this.side = s;
    }

    public int roll(){
        Random random = new Random();
        side = random.nextInt(6) +1;
        return side;
    }
}
