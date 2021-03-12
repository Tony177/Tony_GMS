package com.team20.gym_manager;

import java.time.LocalTime;
import java.util.ArrayList;

public class day
{
    
    private LocalTime h_open;
    private LocalTime h_close;
    private ArrayList<lesson> lessons = new ArrayList<lesson>();
    
    public day()
    {
        
    }
    
    public void set_lesson(ArrayList<lesson> l)
    {
        this.lessons = l;
    }

    public LocalTime getH_close()
    {
        return this.h_close;
    }
    
    /**
     * 
     * @param h_close
     */
    public void setH_close(LocalTime h_close)
    {
        this.h_close = h_close;
    }
    
    public LocalTime getH_open()
    {
        return this.h_open;
    }
    
    /**
     * 
     * @param h_open
     */
    public void setH_open(LocalTime h_open)
    {
        this.h_open = h_open;
    }
    
    public lesson get_lesson(String course_name, LocalTime h_start)
    {
        for (lesson l : lessons)
        {
            if (l.getH_start() == h_start
                    && l.get_course().getName() == course_name)
            {
                return l;
            }
        }
        return new lesson(); // Fare lesson costruttore nullo
    }
    
    public ArrayList<lesson> search_lessons(LocalTime h_start)
    {
        ArrayList<lesson> r_lessons = new ArrayList<lesson>();
        for (lesson l : lessons)
        {
            if (l.getH_start().equals(h_start))
            {
                r_lessons.add(l);
            }
        }
        return r_lessons;
    }
    /**
     * search lessons by the course name and return a list of lessons of that
     * course
     * 
     * @param name
     */
    public ArrayList<lesson> search_lessons(String name)
    {
        ArrayList<lesson> r_lessons = new ArrayList<lesson>();
        for (lesson l : lessons)
        {
            if (l.get_course().getName().equals(name))
            {
                r_lessons.add(l);
            }
        }
        return r_lessons;
    }
    
    public ArrayList<lesson> get_lessons()
    {
        ArrayList<lesson> r_lessons = new ArrayList<lesson>();
        for (lesson l : lessons)
        {
            r_lessons.add(l);
        }
        
        return r_lessons;
    }
    
}
