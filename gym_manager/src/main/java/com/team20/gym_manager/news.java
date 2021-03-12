package com.team20.gym_manager;

public class news
{
    
    private String title;
    private String body;
    
    /**
     * 
     * @param title
     * @param body
     */
    public news(String title, String body)
    {
        this.title = title;
        this.body = body;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public String getBody()
    {
        return this.body;
    }
    
}
