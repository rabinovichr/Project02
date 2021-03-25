package Project02;

import Project02.People;
import Project02.PeopleType;
/**
 * This class is one of the PeopleType of the tribe (Warrior)
 * where you develop a encounter strategy.
 */

public class CoryWarrior1 extends Project02.People
{
    CoryWarrior1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, Project02.PeopleType.warrior, lifePoints);
        myDescription = "\tCory Warrior";
    }


    /**
     * This class allow to the have a strategy for when you encounter another
     * person through out the game.
     * @param otherPerson
     * @return the amount of life points after the encounter
     */


    public int encounterStrategy(Project02.People otherPerson)
    {
        int lifePoints = 0;
        if(this.getNation() == otherPerson.getNation())
        {
            if(otherPerson.getLifePoints() < this.getLifePoints())
            {
                if(otherPerson.getTribe() == this.getTribe())
                {
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2);
                }
                else
                {
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 4);
                }
            }
        }
        else
        {
            int points;
            points = this.getLifePoints() - otherPerson.getLifePoints();
            if (points > 0)
            {
                lifePoints = otherPerson.getLifePoints();
            }
            else
            {
                lifePoints = this.getLifePoints();
            }
        }
        return lifePoints;
    }

}
