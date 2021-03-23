package Project02;

import Project02.People;
import Project02.PeopleType;


public class BenWizard2 extends Project02.People {

    BenWizard2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tBen Wizard 2";
    }

    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getType() == PeopleType.warrior) {
                    lifePoints = -this.getLifePoints();
                }
                else {
                    lifePoints = (int) (this.getLifePoints()/2);
                }
            }

        }
        else {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
            }
            else {
                lifePoints = 0;
            }
        }
        return lifePoints;
    }
}