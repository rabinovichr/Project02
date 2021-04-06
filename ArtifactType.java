package Project02;


public enum ArtifactType {

    //No artifacts found, damage as dice roll
    nothing ("No Artifacts Enabled"),
    //Trained peopletype for 1 round, damage +5
    mentors ("Trained by Liam Neeson"),
    //For warrior add damage +10
    weapon ("Found Titanium Sword"),
    //Once chosen, immune from damage that round
    shield ("Found Golden Shield"),
    //Instakill
    boobytrap ("Fell into snake pit");

    private String description;


    /**
     * Sets the string type to description.
     * @param types
     */

    ArtifactType (String types)
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
