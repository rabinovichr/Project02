package Project02;

import Project02.People;
import Project02.PeopleType;

/**
 * This class is one of the PeopleType of the tribe (healer)
 * where you develop a encounter strategy.
 */
public class BenHealer2 extends Project02.People {

    BenHealer2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tBen Healer2";
    }

    /**
     * This class allow to the have a strategy for when you encounter another
     * person through out the game.
     * @param otherPerson
     * @return the amount of life points after the encounter
     */

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) { //run away
            lifePoints = -this.getLifePoints();
        }
        else { // heal warriors only
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getType() == PeopleType.warrior) {
                    lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
                }
            }
            else lifePoints = 0;
        }
        return lifePoints;
    }
}
