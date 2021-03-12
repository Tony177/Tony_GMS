package com.team20.gym_manager;

import java.util.Date;

public class subscription
{
    
    private int id;
    private Date start_date;
    private boolean is_annual;
    private float price;
    private int month;
    private Date end_date;
    
    public Date getStart_date()
    {
        return this.start_date;
    }
    
    /**
     * 
     * @param start_date
     */
    public void setStart_date(Date start_date)
    {
        this.start_date = start_date;
    }
    
    public float getPrice()
    {
        return this.price;
    }
    
    /**
     * 
     * @param price
     */
    public void setPrice(float price)
    {
        this.price = price;
    }
    
    public int getMonth()
    {
        return this.month;
    }
    
    /**
     * 
     * @param month
     */
    public void setMonth(int month)
    {
        this.month = month;
    }
    
    public Date getEnd_date()
    {
        return this.end_date;
    }
    
    /**
     * 
     * @param end_date
     */
    public void setEnd_date(Date end_date)
    {
        this.end_date = end_date;
    }
    
    public boolean is_annual()
    {
        return this.is_annual;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    /**
     * 
     * @param start_date
     * @param is_annual
     * @param price
     * @param month
     * @param end_date
     */
    public subscription(int id, Date start_date, boolean is_annual, float price,
            int month, Date end_date)
    {
        this.id = id;
        this.start_date = start_date;
        this.is_annual = is_annual;
        this.price = price;
        this.month = month;
        this.end_date = end_date;
    }
    
}
