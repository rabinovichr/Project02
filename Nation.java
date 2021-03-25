package Project02;

import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import Project02.Tribe;
import Project02.People;

public class Nation
{
    /**
     * This class allows you to manage the nation by adding the names of the nation,
     * establishing all the tribe members, the entire population of the game, and
     * and the living population at the end of the game.
     */
    private int nationLifePoints;
    private String nationName;
    private ArrayList<Tribe> tribes = new ArrayList<>();
    private ArrayList<People> population = new ArrayList<>();
    private ArrayList<People> livingPopulation = new ArrayList<>();

    /**
     * This class instantiates the enitre nation with adding everyone that is
     * inolved in the game which is the tribe members.
     * @param name
     * @param lifePoints
     */
    public Nation(String name, int lifePoints)
    {
        nationName = name;
        nationLifePoints = lifePoints;
        for(int i = 0; i < 5; i++)
        {
            this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 6));
        }
        population.addAll(getNationPopulation());
        livingPopulation.addAll(population);
    }

    /**
     * Puts all the members of the nation in one list
     *
     * @return all the memebers of the tribe that is still alive through out the
     * game within the tribes.
     */

    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for(int tribe = 0; tribe < this.tribes.size(); tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(tribes.get(tribe).getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += tribes.get(tribe).getTribeLifePoints();
            }
        }
        return livingPopulation;
    }

    /**
     * Gets the nations name
     *
     * @return the names of each nation
     */
    public String getNationName()
    {
        return nationName;
    }

    /**
     * prints the status of the Tribe members within the game.
     */


    public void printTribesStatus()
    {
        for(int tribe = 0; tribe < 1; tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    public String toString()
    {
        String result = "\0";
        result = nationName;
        for(int i = 0; i < tribes.size(); i++)
        {
            result = result + '\n' + tribes.get(i).toString();

        }
        result = result + '\n';
        return result;
    }
}
