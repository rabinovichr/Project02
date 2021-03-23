package Project02;

import Project02.People;
import Project02.PeopleType;

public class BenWarrior1 extends People {

    public BenWarrior1(String nation, String tribe, int lifepoints) {
        super(nation, tribe, PeopleType.warrior, lifepoints);
        myDescription = "\tBen Warrior";
    }

    public int encounterStrategy(People otherPerson) {
        int lifepoints = 0;
        if (this.getNation() == otherPerson.getNation()) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getTribe() == this.getTribe()) {
                    lifepoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 8);
                }
                else {
                    lifepoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 4);
                }
            }
        }
        else {
            int points;
            points = this.getLifePoints() - otherPerson.getLifePoints();
            if (points > 0) {
                lifepoints = otherPerson.getLifePoints();
            }
            else {
                lifepoints = this.getLifePoints();
            }
        }
        return lifepoints;
    }

}