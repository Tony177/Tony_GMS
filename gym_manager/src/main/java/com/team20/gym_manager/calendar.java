package com.team20.gym_manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class calendar
{
    private Map<week_day, day> week = new HashMap<>(7);
    
    /**
     * 
     * @param day
     */
    public day get_day(week_day day)
    {
        return week.get(day);
    }
    
    public Map<week_day, day> get_days()
    {
        return week;
    }
    
    public calendar(ArrayList<day> week_list)
    {
        int i = 0;
        if (week_list.size() != 7)
        {
            throw new ExceptionInInitializerError(
                    "La lista dei giorni deve essere lunga sette.\n");
        }
        for (day d : week_list)
        {
            week.put(week_day.values()[i], d);
            i++;
        }
    }
}
