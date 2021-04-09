//
//  Name:       Kwan, Wesley
//  Project:    2
//  Due:        03/07/20
//  Course:     cs-2400-02
//
//  Description:
//              Stores the name and value of variables.
//
public class Name
{
    private String name;
    private int value;
    
    public Name(String name, int value)
    {
        this.name = name;
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
    
    public String getName()
    {
        return name;
    }
}
