package Project02;

public enum PeopleType
{
    wizard  ("wizard"),
    warrior ("warrior"),
    healer  ("healer"),
    //No artifacts found, damage as dice roll
    nothing ("No Artifacts Enabled"),
    //Trained peopletype for 1 round, damage +5
    mentors ("Trained by Liam Neeson"),
    //For warrior add damage +10
    poisonpotion ("Drank Bleach"),
    //Once chosen, immune from damage that round
    shield ("Found Golden Shield"),
    //Instakill
    boobytrap ("Fell into snake pit");
    /**
     * This class shows the type of people in each tribe
     * which is a wizard, warrior, and healer.
     */

    private String description;


    /**
     * Sets the string type to description.
     * @param types
     */

    PeopleType (String types)
    {
        description = types;
    }

    /**
     * Shows a descriptions of what PeopleType it is
     * @return description
     */

    public String getDescription()
    {
        return description;
    }
}
