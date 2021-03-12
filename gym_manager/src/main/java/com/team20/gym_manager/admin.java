package com.team20.gym_manager;

public class admin extends user
{
    
    public admin(user user_in)
    {
        super(user_in.getUsername(), user_in.getPassword(), user_in.getName());
    }
    
}
