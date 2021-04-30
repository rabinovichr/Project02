package Project02;

import Project02.Nation;
import Project02.People;
import java.util.*;


/**
 * The World class allows to manage of the game is played.
 * Such as the total number of life points, number of rounds.
 * It tells you the nation who won and all the survivors from that winning nation
 */
public class World
{
    private final int worldLifePoints = 10000;
    private final int artifactLifePoints = 8;
    private static final int numberOfRounds = 75;
    private ArrayList<Nation> allNations = new ArrayList<>();
    private ArrayList<Nation> allLivingNations = new ArrayList<>();
    Project02.Dice dice = new Project02.Dice(6);
    Random generator;
    ArrayList<People> worldCreatedPeople = new ArrayList<>();




    public World()
    {
        /*
         seed for psuedo-random number generator
         */
        Date seed = new Date();
        generator = new Random(seed.getTime());
        createWorld();
        worldCreatedPeople.addAll(getWorldCreatedPopulation());
    }

    /**
     * This method shows the list of survivors at the end of the game.
     */

    public void war()
        {
            ArrayList<Integer> worldSurvivingPeople = new ArrayList<>();

            for(int round = 1; round < numberOfRounds; round++)
            {
                Set<String> survivingNations = new HashSet<>();
                System.out.println("Round number: " + round);
                worldSurvivingPeople.clear();
                worldSurvivingPeople.addAll(getWorldSurvivingPeople());
                survivingNations.addAll(getSurvivingNations());
                if ((worldSurvivingPeople.size() >= 2) && (survivingNations.size() > 1) )
                    playOneRound(worldSurvivingPeople);
                else
                {
                    System.out.print("Game is over! Winning Nation is: ");
                    if (survivingNations.size() == 0)
                    {
                        System.out.println("All Nations Distroyed.");
                    }
                    else
                    {
                        System.out.println(survivingNations);
                        System.out.println("The survivors are:");
                        for (Integer i = 0; i < worldSurvivingPeople.size(); i++)
                        {
                            System.out.println(worldCreatedPeople.get(worldSurvivingPeople.get(i)));
                        }
                    }
                    break;
                }

            }

    }


    /**
     * This method allows to add all the nation that are going to be in the game
     * and divid the points amongst the nations
     */
    public void createWorld()
    {
        allNations.add(new Nation("RobertNation", (worldLifePoints / 3)));
        allNations.add(new Nation("CoryNation", (worldLifePoints) / 3));
        allNations.add(new Nation("BenNation", (worldLifePoints) / 3));
        allNations.add(new Nation("Artifacts", (artifactLifePoints)));

    }


    /**
     * Adding all the living people from allNations to living people
     * @return all the living people
     */
    public ArrayList<People> getWorldCreatedPopulation()
    {
        ArrayList<People> livingPeople = new ArrayList<>();
        for(int nation = 0; nation < allNations.size(); nation++)
            livingPeople.addAll(allNations.get(nation).getNationPopulation());
        //System.out.println(livingPeople);
        return livingPeople;
    }


    /**
     * Add all the survivors of the living people from all nations to living
     * people to a list
     * @return  all the survivors
     */
    public ArrayList<Integer> getWorldSurvivingPeople()
    {
        ArrayList<Integer> survivors = new ArrayList<>();
        for (Integer i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivors.add(i);
            }
        }
        return survivors;
    }

    public static int getNumberOfRounds(){
        return numberOfRounds;
    }

    /**
     * get the surving nation at the end of the game
     * @return the surviving nation.
     */
    public Set<String> getSurvivingNations()
    {
        Set<String> survivingNations = new HashSet<>();

        for (Integer i = 0; i < worldCreatedPeople.size(); i++)
        {
            if(worldCreatedPeople.get(i).isPersonAlive())
            {
                survivingNations.add(worldCreatedPeople.get(i).getNation());
            }
        }
        return survivingNations;
    }

    /**
     * Manage the encounters between two people
     * @param person1
     * @param person2
     */
    public void encounter(Integer person1, Integer person2)
    {
        Integer person1LifePointsToUse;
        Integer person2LifePointsToUse;
        System.out.println("Encounter: " + worldCreatedPeople.get(person1) + " " + "vs. " + worldCreatedPeople.get(person2));

        //if lifePointsToUse is negative, then person is either running away in a hostile encounter
        // or person is giving life points to another person from same nation
        person1LifePointsToUse = worldCreatedPeople.get(person1).encounterStrategy(worldCreatedPeople.get(person2));
        person2LifePointsToUse = worldCreatedPeople.get(person2).encounterStrategy(worldCreatedPeople.get(person1));

        // amount of life points actually used is subject to a psuedo-random encounter
        Integer p1damage =  (dice.roll() * 2);
        Integer p2damage =  (dice.roll() * 2);

        if ((p1damage > 0) && (p2damage > 0))  // person 1  and person 2 are fighting and inflicting damage
        {
            p2damage =  (dice.roll() * (worldCreatedPeople.get(person1).getType().ordinal()+1)*p1damage);
            p1damage =  (dice.roll() * (worldCreatedPeople.get(person2).getType().ordinal()+1)*p2damage);
        }
        else if ((p1damage > 0) && (p2damage <= 0)) // person 1 is fighting and person 2 is running
        {
            p2damage =  (dice.roll() * (worldCreatedPeople.get(person1).getType().ordinal()+1)*(p1damage/3));
        }
        else if ((p1damage <= 0) && (p2damage > 0)) // person 2 is fighting and person 1 is running
        {
            p1damage =  (dice.roll() * (worldCreatedPeople.get(person2).getType().ordinal()+1)*(p2damage/3));
        }
        else // freindly encounter, do nothing
        {

        }

        // record the damage: positive damage should be subtracted for persons lifePoint
        // negative damage is added to persons life points
        worldCreatedPeople.get(person1).modifyLifePoints((-p2damage));
        worldCreatedPeople.get(person2).modifyLifePoints((-p1damage ));

        // Both people lose 1 life point per encounter due to aging
        worldCreatedPeople.get(person1).modifyLifePoints((-1));
        worldCreatedPeople.get(person2).modifyLifePoints((-1));

    }

    /**
     * Allows to play a round of the game
     * @param combatants
     */
    public void playOneRound(ArrayList<Integer> combatants)
    {
        System.out.println(combatants.size());
        ArrayList<Integer> survivors = new ArrayList<>();
        Integer numberOfCombatants;
        Collections.shuffle(combatants);
        numberOfCombatants = combatants.size()-1;
        Integer combatantIndex = 0;
        while(combatantIndex < numberOfCombatants)
        {
            encounter(combatants.get(combatantIndex), combatants.get(combatantIndex+1));
            combatantIndex = combatantIndex + 2;
        }
    }



}
