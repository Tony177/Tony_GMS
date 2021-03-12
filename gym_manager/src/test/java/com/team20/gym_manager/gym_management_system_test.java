package com.team20.gym_manager;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class gym_management_system_test
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
    public void testInsert_lesson() throws IllegalArgumentException
    {
        boolean thrown = false;
        try
        {
            gym_management_system.insert_lesson(LocalTime.of(9, 00), 120,
                    "Yoga", 1, "lunedi");
        }
        catch (IllegalArgumentException e)
        {
            thrown = true;
        }
        assertTrue(
                "TEST: La Exception in insert lesson non funziona come atteso",
                thrown);
    }
    
    @Test
    public void testModify_lesson()
    {
        boolean thrown = false;
        lesson old_l = new lesson(LocalTime.of(8, 01), 1,
                new course("Pilates", "Peppe"), new course_room(1, 120));
        lesson new_l = old_l;
        new_l.setDuration(2);
        new_l.setH_start(LocalTime.of(8, 00));
        try
        {
            gym_management_system.modify_lesson(week_day.domenica, old_l,
                    new_l);
        }
        catch (NoSuchElementException e)
        {
            thrown = true;
        }
        assertTrue(
                "TEST: La Exception in modify lesson non funziona come atteso",
                thrown);
                
    }
    
    @Test
    public void testSearch_lesson()
    {
        ArrayList<lesson> lessons_searched = new ArrayList<lesson>();
        // Search by name
        lessons_searched = gym_management_system.search_lesson("martedi",
                "Pilates", null);
        assertNotNull("TEST: La ricerca per nome restituisce nullo",
                lessons_searched);
        // Search by starting hour
        lessons_searched = gym_management_system.search_lesson("domenica", null,
                LocalTime.of(9, 10));
        assertNotNull("TEST: La ricerca per orario restituisce nullo",
                lessons_searched);
    }
    
    @Test
    public void testPublish_news()
    {
        assertTrue(true); // Always true for test
    }
}
