package com.team20.gym_manager;

public class exercise
{
    
    private short ripetition;
    private short frequency;
    private String name;
    
    public short getRipetition()
    {
        return this.ripetition;
    }
    
    /**
     * 
     * @param ripetition
     */
    public void setRipetition(short ripetition)
    {
        this.ripetition = ripetition;
    }
    
    public short getFrequency()
    {
        return this.frequency;
    }
    
    /**
     * 
     * @param frequency
     */
    public void setFrequency(short frequency)
    {
        this.frequency = frequency;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    /**
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    public exercise(short ripetition, short frequency, String name)
    {
        this.ripetition = ripetition;
        this.frequency = frequency;
        this.name = name;
    }
}
