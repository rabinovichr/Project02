package Project02;

import Project02.People;
import Project02.PeopleType;

/**
 * This class is one of the PeopleType of the tribe (Wizard)
 * where you develop a encounter strategy.
 */
public class CoryWizard1 extends Project02.People

{
    CoryWizard1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, Project02.PeopleType.wizard, lifePoints);
        myDescription = "\tCory Wizard";
    }

    /**
     * This class allow to the have a strategy for when you encounter another
     * person through out the game.
     * @param otherPerson
     * @return the amount of life points after the encounter
     */

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation())
        {
            if (otherPerson.getLifePoints() < this.getLifePoints())
            {
                if (otherPerson.getType() == Project02.PeopleType.warrior) // run away
                {
                    lifePoints = -this.getLifePoints();
                }
                else // attack a wizard
                {
                    lifePoints = (int) (this.getLifePoints()/2);
                }
            }
        }
        else
        {
            if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend
            {
                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
            }
            else
            {
                lifePoints = 0;
            }
        }
        return lifePoints;
    }

}