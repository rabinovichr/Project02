package Project02;

import Project02.People;
import Project02.PeopleType;
/**
 * This class is one of the PeopleType of the tribe (Wizard)
 * where you develop a encounter strategy.
 */


public class BenWizard2 extends Project02.People {

    BenWizard2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tBen Wizard 2";
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
            if(otherPerson.getLifePoints() < this.getLifePoints()) {
                if(otherPerson.getType() == PeopleType.wizard || otherPerson.getType() == PeopleType.healer) {
                    lifePoints = -(int) this.getLifePoints() / 2; // attacks healers and wizards
                }
                else {
                    lifePoints = -this.getLifePoints(); // run away if it's against warrior.
                }
            }
        }
        return lifePoints;
    }
}