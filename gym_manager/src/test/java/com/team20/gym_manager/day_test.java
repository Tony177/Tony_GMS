package com.team20.gym_manager;

import static org.junit.Assert.*;

import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class day_test
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
    public void testSearch_lessonsLocalTime()
    {
        day my_day = new day();
        ArrayList<lesson> l = new ArrayList<lesson>();
        lesson l1 = new lesson(LocalTime.of(21, 00), 120,
                new course("Yoga", "Peppe"), new course_room(1, 120));
        lesson l2 = new lesson(LocalTime.of(18, 00), 120,
                new course("Pilates", "Carmine"), new course_room(1, 40));
        lesson l3 = new lesson(LocalTime.of(18, 00), 120,
                new course("Yoga", "Peppe"), new course_room(1, 120));
        l.add(l1);
        l.add(l2);
        l.add(l3);
        my_day.set_lesson(l);
        ArrayList<lesson> exp = new ArrayList<lesson>();
        exp.add(l2);
        exp.add(l3);
        assertArrayEquals("TEST: Ricerca lezione per orario errata",
                exp.toArray(),
                my_day.search_lessons(LocalTime.of(18, 00)).toArray());
    }
    
    @Test
    public void testSearch_lessonsString()
    {
        day my_day = new day();
        ArrayList<lesson> l = new ArrayList<lesson>();
        lesson l1 = new lesson(LocalTime.of(21, 00), 120,
                new course("Yoga", "Peppe"), new course_room(1, 120));
        lesson l2 = new lesson(LocalTime.of(18, 00), 120,
                new course("Pilates", "Carmine"), new course_room(1, 40));
        lesson l3 = new lesson(LocalTime.of(18, 00), 120,
                new course("Yoga", "Peppe"), new course_room(1, 120));
        l.add(l1);
        l.add(l2);
        l.add(l3);
        my_day.set_lesson(l);
        ArrayList<lesson> exp = new ArrayList<lesson>();
        exp.add(l1);
        exp.add(l3);
        assertArrayEquals("TEST: Ricerca lezione per corso errata",
                exp.toArray(), my_day.search_lessons("Yoga").toArray());
    }
    
    @Test
    public void testGet_lessons()
    {
        day my_day = new day();
        ArrayList<lesson> l = new ArrayList<lesson>();
        lesson l1 = new lesson(LocalTime.of(21, 00), 120,
                new course("Yoga", "Peppe"), new course_room(1, 120));
        lesson l2 = new lesson(LocalTime.of(18, 00), 120,
                new course("Pilates", "Carmine"), new course_room(1, 40));
        lesson l3 = new lesson(LocalTime.of(18, 00), 120,
                new course("Yoga", "Peppe"), new course_room(1, 120));
        l.add(l1);
        l.add(l2);
        l.add(l3);
        my_day.set_lesson(l);
        ArrayList<lesson> exp = new ArrayList<lesson>();
        exp.add(l1);
        exp.add(l2);
        exp.add(l3);
        assertArrayEquals("TEST: Get lessons errato", exp.toArray(),
                my_day.get_lessons().toArray());
    }
}
