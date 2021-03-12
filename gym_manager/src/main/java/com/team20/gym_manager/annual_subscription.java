package com.team20.gym_manager;

import java.util.Date;

public class annual_subscription extends subscription
{
    
    private Date suspension_date;
    
    public Date getSuspension_date()
    {
        return this.suspension_date;
    }
    
    /**
     * 
     * @param suspension_date
     */
    public void setSuspension_date(Date suspension_date)
    {
        this.suspension_date = suspension_date;
    }
    
    /**
     * 
     * @param start_date
     * @param is_annual
     * @param price
     * @param month
     * @param end_date
     * @param suspension_date
     */
    public annual_subscription(subscription sub, Date suspension_date)
    {
        super(sub.getId(), sub.getStart_date(), sub.is_annual(), sub.getPrice(),
                sub.getMonth(), sub.getEnd_date());
        this.suspension_date = suspension_date;
    }
    
}
