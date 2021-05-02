package Project02;
import Project02.People;
import Project02.PeopleType;


/**
 * This class is one of the ArtifactType of the tribe (Posion)
 * where you develop a encounter strategy.
 */
public class PoisonArtifact extends Project02.People {

    PoisonArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.poisonpotion, lifePoints);
        myDescription = "\tDrank poison";
    }


    /**
     *This method allows you to the have a strategy for when you encounter another person through out the game.
     * @param otherPerson
     * @return the amount of life points after the encounter
     */
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        //If nations are equal and both are mentors run away
        if (this.getNation() == otherPerson.getNation()) {
            lifePoints = -this.getLifePoints();


        }
        else
            return 0;
        return lifePoints;
    }
}