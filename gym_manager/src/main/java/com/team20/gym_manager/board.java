package com.team20.gym_manager;

import java.util.ArrayList;

public class board
{
    private ArrayList<news> news = new ArrayList<news>();
    
    public board()
    {
    }
    
    public ArrayList<news> get_news()
    {
        return news;
    }
    
    /**
     * 
     * @param title
     * @param body
     */
    public void create_news(String title, String body)
    {
        news add_news = new news(title, body);
        news.add(add_news);
    }
    
}
