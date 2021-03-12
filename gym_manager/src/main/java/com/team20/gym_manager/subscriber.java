package com.team20.gym_manager;

public class subscriber extends user
{
    private String surname;
    private String email;
    private subscription sub;
    private training_card card;
    
    public String getSurname()
    {
        return this.surname;
    }
    
    /**
     * 
     * @param surname
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    /**
     * 
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * 
     * @param name
     * @param surname
     * @param email
     * @param sub
     */
    public subscriber(user user_in, String surname, String email,
            subscription sub)
    {
        super(user_in.getUsername(), user_in.getPassword(), user_in.getName());
        this.surname = surname;
        this.email = email;
        this.sub = sub;
    }
    
    public training_card get_training_card()
    {
        return card;
    }
    
    public subscription get_subscription()
    {
        return sub;
    }
    
}
