package Project02;

import Project02.PeopleType;

public abstract class People
{
    private String personName;
    private String myNation;
    private String myTribe;
    private PeopleType me;
    protected String myDescription;
    private int myLifePoints;
    private boolean dead;


    /**
     * This class allow you to manage who exactly is fighting who through out the
     * game.
     * So this help you give the names of each nation, tribe, and people type.
     * @param nation
     * @param tribe
     * @param person
     * @param lifePoints
     */


    public People(String nation, String tribe, PeopleType person, int lifePoints)
    {
        myNation = nation;
        myTribe = tribe;
        me = person;
        myDescription = me.getDescription();
        myLifePoints = lifePoints;
        dead = false;
    }

    /**
     * This method allows you to set dead equal to true.
     */

    public void setDead()
    {
        dead = true;
    }

    /**
     * This method allows you to see if the someone
     * is dead.
     * @return dead
     */

    public boolean getDead()
    {
        return dead;
    }

    /**
     * Get the type of person within the tribe.
     * @return me
     */

    public PeopleType getType()
    {
        return me;
    }

    /**
     * Get the name of the tribe
     * @return the tribe
     */

    public String getTribe()
    {
        return myTribe;
    }

    /**
     * Get the name of the nation
     * @return the nation
     */

    public String getNation()
    {
        return myNation;
    }

    /**
     * This method establish if the person has any life points
     * @return if the person is alive or not.
     */

    public Boolean isPersonAlive()
    {
        return (myLifePoints > 0);
    }

    /**
     * This method establish the life points
     * @return the life points
     */

    public int getLifePoints()
    {
        return myLifePoints;
    }

    /**
     * This methods allows you to moditify the life points as the game progress
     * @param points
     */

    public void modifyLifePoints(int points)
    {
        myLifePoints += points;
    }




    public abstract int encounterStrategy(People otherPerson);



    public String toString()
    {
        String result = new String( myNation + "\t" +  myTribe + "\t" + me + "\t" + myDescription + "\t" + myLifePoints);
        return result;
    }
}

