package com.team20.gym_manager;

public class course
{
    private String name;
    private String trainer;
    
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
    
    public String getTrainer()
    {
        return this.trainer;
    }
    
    /**
     * 
     * @param trainer
     */
    public void setTrainer(String trainer)
    {
        this.trainer = trainer;
    }
    
    /**
     * 
     * @param name
     * @param trainer
     */
    public course(String name, String trainer)
    {
        this.name = name;
        this.trainer = trainer;
    }
    public course()
    {
        
    }
    
}
