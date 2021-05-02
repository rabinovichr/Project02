package Project02;
import Project02.People;
import Project02.PeopleType;


/**
 * This class is one of the ArtifactType of the tribe (Shield)
 * where you develop a encounter strategy.
 */
public class ShieldArtifact extends Project02.People {

    ShieldArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.shield, lifePoints);
        myDescription = "\tProtected by Shield";
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