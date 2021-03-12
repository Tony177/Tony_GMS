package com.team20.gym_manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import com.team20.gym_manager.*;

/**
 * calendar_dao This class helps handling the calendar sync with the database.
 * Its implemented as a Singleton
 */
public class calendar_dao
{
    private static ArrayList<course> _courses = new ArrayList<course>();
    private static ArrayList<course_room> _course_rooms = new ArrayList<course_room>();
    private static ArrayList<ArrayList<lesson>> _lessons = new ArrayList<ArrayList<lesson>>();
    private static calendar _calendar = null;
    private static calendar_dao _instance = null;
    
    public static calendar_dao get_istance()
    {
        if (_instance == null)
        {
            _instance = new calendar_dao();
        }
        
        return _instance;
    }
    
    private calendar_dao()
    {
        for (int i = 0; i < week_day.values().length; i++)
        {
            _lessons.add(i, null);
        }
    }
    
    private void download_courses()
    {
        try
        {
            Connection conn = db_manager.get_istance().get_connection();
            Statement s = null;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM course");
            
            while (rs.next())
            {
                course course_temp = new course();
                course_temp.setName(rs.getString("name"));
                course_temp.setTrainer(rs.getString("trainer"));
                
                _courses.add(course_temp);
            }
            s.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getErrorCode());
            System.out.println("Errore Connection DB\n");
        }
    }
    
    private void download_course_rooms()
    {
        try
        {
            Connection conn = db_manager.get_istance().get_connection();
            Statement s = null;
            
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM course_room");
            
            while (rs.next())
            {
                course_room room_temp = new course_room();
                room_temp.setId(rs.getInt("id"));
                room_temp.setSeats_number(rs.getInt("seats_number"));
                
                _course_rooms.add(room_temp);
            }
            s.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getErrorCode());
            System.out.println("Errore Connection DB\n");
        }
    }
    
    private void download_lessons_by_day(week_day day)
    {
        ArrayList<lesson> lesson_list = new ArrayList<lesson>();
        ArrayList<course> course_list = get_courses();
        ArrayList<course_room> room_list = get_course_rooms();
        int day_id = day.ordinal();
        
        try
        {
            Connection conn = db_manager.get_istance().get_connection();
            Statement s = null;
            s = conn.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT * FROM lesson WHERE id_day=" + day_id);
            
            while (rs.next())
            {
                lesson lesson_temp = new lesson();
                String course_name_t = rs.getString("course_name");
                
                int room_id_t = rs.getInt("id_room");
                
                lesson_temp.setH_start(rs.getTime("h_start").toLocalTime());
                lesson_temp.setDuration(rs.getInt("duration"));
                
                for (course c : course_list)
                {
                    
                    if (c.getName() == course_name_t)
                    {
                        lesson_temp.setCourse(c);
                        break;
                    }
                }
                for (course_room r : room_list)
                {
                    
                    if (r.getId() == room_id_t)
                    {
                        lesson_temp.setRoom(r);
                        break;
                    }
                }
                lesson_list.add(lesson_temp);
            }
            s.close();
            
        }
        catch (SQLException e)
        {
            System.err.println(e.getErrorCode());
            System.out.println("Errore Connection DB\n");
        }
        _lessons.add(day_id, lesson_list);
    }
    
    private void download_calendar()
    {
        try
        {
            ResultSet rs = db_manager.get_istance().get_connection()
                    .createStatement().executeQuery("SELECT * FROM day");
            int i = 0;
            ArrayList<day> days = new ArrayList<day>();
            while (rs.next())
            {
                day day_t = new day();
                day_t.setH_open(rs.getTime("hour_start").toLocalTime());
                day_t.setH_close(rs.getTime("hour_close").toLocalTime());
                day_t.set_lesson(get_lessons_by_day(week_day.values()[i]));
                days.add(day_t);
                i++;
            }
            _calendar = new calendar(days);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Returs a list of courses that is initalizated from the database. The list
     * is initalizated only on the first call of this method, than returns a
     * cashed version
     *
     * @return the downloaded ArrayList<course>
     */
    public ArrayList<course> get_courses()
    {
        if (_courses.isEmpty())
        {
            download_courses();
        }
        
        return _courses;
    }
    
    /**
     * Returs a list of course_room that is initalizated from the database. The
     * list is initalizated only on the first call of this method, than returns
     * a cashed version
     *
     * @return the downloaded ArrayList<course_room>
     */
    public ArrayList<course_room> get_course_rooms()
    {
        if (_course_rooms.isEmpty())
        {
            download_course_rooms();
        }
        
        return _course_rooms;
    }
    
    /**
     * Returs a list of lessons that is initalizated from the database. The list
     * is initalizated only on the first call of this method, than returns a
     * cashed version. This function takes a week_day to filter the lessons
     *
     * @param day_id
     *            day identifier
     * @return the downloaded ArrayList<lesson> connected to the specified day
     */
    public ArrayList<lesson> get_lessons_by_day(week_day day_id)
    {
        if (_lessons.get(day_id.ordinal()) == null)
        {
            download_lessons_by_day(day_id);
        }
        
        return _lessons.get(day_id.ordinal());
    }
    
    /**
     * Returs a calendar that is initalizated from the database. The calendar
     * object is initalizated only on the first call of this method, than
     * returns a cashed version
     *
     * @return the downloaded clendar
     */
    public calendar get_calendar()
    {
        if (_calendar == null)
        {
            download_calendar();
        }
        
        return _calendar;
    }
    
    /**
     * Allows to insert a lesson in the database.
     * 
     * @param new_lesson
     *            the lesson object to insert into the database
     * @param my_day
     *            in wich day the lesson should be inserted
     */
    public void insert_lesson_dao(lesson new_lesson, week_day my_day)
    {
        try
        {
            Connection conn = db_manager.get_istance().get_connection();
            PreparedStatement s = null;
            s = conn.prepareStatement("INSERT INTO lesson VALUES(?,?,?,?,?)");
            
            // Conversion from LocalTime to sql.Time
            Time tmp_time = Time.valueOf(new_lesson.getH_start());
            s.setInt(1, new_lesson.get_course_room().getId());
            s.setString(2, new_lesson.get_course().getName());
            s.setInt(3, my_day.ordinal());
            s.setTime(4, tmp_time);
            s.setInt(5, new_lesson.getDuration());
            s.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        
    }
    public void modify_lesson_dao(week_day my_day, lesson old_lesson,
            lesson new_lesson)
    {
        try
        {
            PreparedStatement s = db_manager.get_istance().get_connection()
                    .prepareStatement(
                            "UPDATE lesson SET ID_ROOM=?, COURSE_NAME=?, ID_DAY=?, H_START=?, DURATION=? WHERE H_START=? AND COURSE_NAME=? AND ID_DAY=?");
    
            Time tmp_time = Time.valueOf(new_lesson.getH_start());
            s.setInt(1, new_lesson.get_course_room().getId());
            s.setString(2, new_lesson.get_course().getName());
            s.setInt(3, my_day.ordinal());
            s.setTime(4, tmp_time);
            s.setInt(5, new_lesson.getDuration());
            Time tmf_time = Time.valueOf(old_lesson.getH_start());
            s.setTime(6, tmf_time);
            s.setString(7, new_lesson.get_course().getName());
            s.setInt(8, my_day.ordinal());
            s.executeUpdate();
            
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            
        }
    }
}
// id_room=?, course_name=?, id_day=?, h_start=?, duration=? WHERE h_start=? AND
// course_name=? AND id_day=?
