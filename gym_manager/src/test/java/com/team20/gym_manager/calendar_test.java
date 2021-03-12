package com.team20.gym_manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class calendar_test
{
    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }
    
    @Before
    public void setUp() throws Exception
    {
    }
    
    @After
    public void tearDown() throws Exception
    {
    }
    
    @Test
            public void testCalendar()
    {
        
        ArrayList<day> days = new ArrayList<day>();
        for (int i = 0; i < week_day.values().length - 1; i++)
        {
            days.add(new day());
        }
        
        boolean error = false;
        
        try
        {
            new calendar(days);
        }
        catch (ExceptionInInitializerError e)
        {
            error = true;
        }
        
        assertTrue("TEST: Calendar non controlla dimensione correttamente",
                error);
        days.add(new day());
        error = false;
        
        try
        {
            new calendar(days);
        }
        catch (ExceptionInInitializerError e)
        {
            error = true;
        }
        assertFalse("TEST: Costruttore calendar funziona correttamente", error);
    }
    
}
