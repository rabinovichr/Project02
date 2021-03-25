package Project02;

public enum PeopleType
{
    wizard  ("wizard"),
    warrior ("warrior"),
    healer  ("healer");
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
