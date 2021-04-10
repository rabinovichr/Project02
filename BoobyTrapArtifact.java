package Project02;
import Project02.People;
import Project02.PeopleType;


/**
 * This class is one of the PeopleType of the tribe (healer)
 * where you develop a encounter strategy.
 */
public class BoobyTrapArtifact extends Project02.People {

    BoobyTrapArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.mentors, lifePoints);
        myDescription = "\tInstaKilled";
    }


    /**
     * This class allow to the have a strategy for when you encounter another
     * person through out the game.
     *
     * @param otherPerson
     * @return the amount of life points after the encounter
     */
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() == otherPerson.getNation()) {
            if (otherPerson.getType() == PeopleType.mentors) {
                lifePoints = -this.getLifePoints();
            }
        } else {
            lifePoints = 0;

        }
        return(0);
    }
}