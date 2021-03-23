package Project02;

import Project02.People;
import Project02.PeopleType;
public class CoryWizard2 extends Project02.People
{
    CoryWizard2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, Project02.PeopleType.wizard, lifePoints);
        myDescription = "\tCory Wizard";
    }

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
