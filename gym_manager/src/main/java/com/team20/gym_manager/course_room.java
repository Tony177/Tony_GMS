package com.team20.gym_manager;

public class course_room
{
    private int id;
    private int seats_number;
    
    public int getSeats_number()
    {
        return this.seats_number;
    }
    
    /**
     * 
     * @param seats_number
     */
    public void setSeats_number(int seats_number)
    {
        this.seats_number = seats_number;
    }
    
    /**
     * 
     * @param seats_number
     */
    public course_room(int id, int seats_number)
    {
        this.id = id;
        this.seats_number = seats_number;
    }
    public course_room()
    {
        
    }
    public int getId()
    {
        return this.id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    
}
