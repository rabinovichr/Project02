package Project02;
import Project02.People;
import Project02.PeopleType;


/**
 * This class is one of the PeopleType of the tribe (healer)
 * where you develop a encounter strategy.
 */
public class WeaponArtifact extends Project02.People {

    WeaponArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.mentors, lifePoints);
        myDescription = "\tReceived a Sword";
    }


    /**
     * This class allow to the have a strategy for when you encounter another
     * person through out the game.
     * @param otherPerson
     * @return the amount of life points after the encounter
     */
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        //If nations are equal and both are mentors run away
        if (this.getNation() == otherPerson.getNation()) {
            if (otherPerson.getType() == PeopleType.mentors) {
                lifePoints = -this.getLifePoints();
            }
        }
        else {
            if (otherPerson.getLifePoints() < this.getLifePoints()) { // heal a friend
                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
            } else {
                lifePoints = 0;
            }
        }
        return lifePoints;
    }
}