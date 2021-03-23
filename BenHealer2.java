package Project02;

import Project02.People;
import Project02.PeopleType;

public class BenHealer2 extends Project02.People {

    BenHealer2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tBen Healer2";
    }

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
