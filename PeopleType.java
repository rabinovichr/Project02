package Project02;

public enum PeopleType
{
    wizard  ("wizard"),
    warrior ("warrior");

    private String description;

    PeopleType (String types)
    {
        description = types;
    }


    public String getDescription()
    {
        return description;
    }
}
