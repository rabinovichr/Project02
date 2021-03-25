package Project02;

import Project02.People;
import Project02.PeopleType;
/**
 * This class is one of the PeopleType of the tribe (Wizard)
 * where you develop a encounter strategy.
 */
public class BenWizard1 extends Project02.People {

    BenWizard1 (String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tBen Wizard";
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
                if(otherPerson.getType() != PeopleType.wizard) {
                    lifePoints = -(int) this.getLifePoints() / 2; // attacks healers and warriors
                }
                else {
                    lifePoints = -this.getLifePoints(); // run away if it's against another wizard.
                }
            }
        }
        return lifePoints;
    }
}
