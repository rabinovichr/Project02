package Project02;
import Project02.People;
import Project02.PeopleType;


/**
 * This class is one of the PeopleType of the tribe (healer)
 * where you develop a encounter strategy.
 */
public class BenHealer1 extends Project02.People {

    BenHealer1(String nation, String tribe, int lifePoints, int damage) {
        super(nation, tribe, PeopleType.healer, lifePoints);
        myDescription = "\tBen Healer1";
        damage = damage;
    }


    /**
     * This class allow to the have a strategy for when you encounter another
     * person through out the game.
     * @param otherPerson
     * @return the amount of life points after the encounter
     */
    public int encounterStrategy(Project02.People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getType() == PeopleType.healer) { // only attacks healers
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
        if(otherPerson.getNation() == "Artifacts"){
            if(otherPerson.getType() == PeopleType.mentors){
                damage += 5;
            }
            if(otherPerson.getType() == PeopleType.boobytrap){
                lifePoints = 0;
            }
            if(otherPerson.getType() == PeopleType.shield){
                lifePoints = lifePoints;
            }
            if(otherPerson.getType() == PeopleType.weapon){
                damage += 10;
            }

        }
        return lifePoints;
    }
}