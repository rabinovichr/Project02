package Project02;

import Project02.People;
import Project02.PeopleType;

public class BenWarrior2 extends People {

    BenWarrior2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tBen Warrior 2";
    }

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if(this.getNation() == otherPerson.getNation()) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if(otherPerson.getTribe() == this.getTribe()){
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 2);
                }
                else {
                    lifePoints = -((this.getLifePoints() - otherPerson.getLifePoints()) / 8);
                }
            }
        }
        else {
            int points;
            points = this.getLifePoints() - otherPerson.getLifePoints();
            if (points > 0) {
                lifePoints = otherPerson.getLifePoints();
            }
            else {
                lifePoints = this.getLifePoints();
            }
        }
        return lifePoints;
    }
}
