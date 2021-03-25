package Project02;

import Project02.People;
import Project02.PeopleType;
/**
 * This class is one of the PeopleType of the tribe (healer)
 * where you develop a encounter strategy.
 */
public class CoryHealer2 extends Project02.People {

    CoryHealer2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, Project02.PeopleType.healer, lifePoints);
        myDescription = "\tCory Healer1";
    }

    /**
     * This class allow to the have a strategy for when you encounter another
     * person through out the game.
     * @param otherPerson
     * @return the amount of life points after the encounter
     */

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getType() == Project02.PeopleType.healer) { // only attacks healers
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2);
                } else { // run away
                    lifePoints = -this.getLifePoints();
                }
            }
        } else {
            if (otherPerson.getLifePoints() < this.getLifePoints()) { // heal a friend
                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
            } else {
                lifePoints = 0;
            }
        }
        return lifePoints;
    }
}