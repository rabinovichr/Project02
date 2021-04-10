package Project02;
import Project02.People;
import Project02.PeopleType;


/**
 * This class is one of the PeopleType of the tribe (healer)
 * where you develop a encounter strategy.
 */
public class TrainArtifact extends Project02.People {

    TrainArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.mentors, lifePoints);
        myDescription = "\tTrained by Liam Neesen";
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

            return lifePoints;
        }
        return lifePoints;
    }
}