package Project02;

import Project02.People;
import Project02.PeopleType;
public class RobertHealer extends Project02.People {

    RobertHealer(String nation, String tribe, int lifePoints) {
        super(nation, tribe, Project02.PeopleType.healer, lifePoints);
        myDescription = "\tBen Healer1";
    }

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
