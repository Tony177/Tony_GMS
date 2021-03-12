package com.team20.gym_manager;

import java.time.LocalTime;

public class lesson
{
    
    private LocalTime h_start;
    private int duration;
    private course l_course;
    private course_room l_room;
    
    public int getDuration()
    {
        return this.duration;
    }
    
    public boolean equals(lesson other)
    {
        return (other != null) && (this.getClass() == other.getClass())
                && (this.h_start == other.h_start)
                && (this.duration == other.duration)
                && (this.l_course == other.l_course)
                && (this.l_room == other.l_room);
    }
    
    /**
     * 
     * @param duration
     */
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
    
    public LocalTime getH_start()
    {
        return this.h_start;
    }
    
    /**
     * 
     * @param h_start
     */
    public void setH_start(LocalTime h_start)
    {
        this.h_start = h_start;
    }
    
    public course get_course()
    {
        return l_course;
    }
    public void setCourse(course c)
    {
        this.l_course = c;
    }
    public course_room get_course_room()
    {
        return l_room;
    }
    public void setRoom(course_room r)
    {
        this.l_room = r;
    }
    /**
     * 
     * @param h_start
     * @param duration
     * @param course
     * @param room
     */
    public lesson(LocalTime h_start, int duration, course course,
            course_room room)
    {
        this.h_start = h_start;
        this.duration = duration;
        this.l_course = course;
        this.l_room = room;
    }
    
    public lesson()
    {
        
    }
    
}
