package com.team20.gym_manager;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.team20.gym_manager.dao.*;

public class gym_management_system
{
    /**
     * 
     * @param h_start
     *            type LocalTime
     * 
     * @param duration
     *            type int
     * 
     * @param course_name
     *            type String, function implements conversion inside
     *            
     * @param id_room
     *            type int
     * 
     * @param day
     *            type String, function implements conversion inside
     */
    public static void insert_lesson(LocalTime h_start, int duration,
            String course_name, int id_room, String s_my_day)
    {
        // if lessons at the same time are also in the same room, raise the
        // exception
        ArrayList<lesson> temp_list = gym_management_system
                .search_lesson(s_my_day, null, h_start);
        
        if (!temp_list.isEmpty())
        {
            for (lesson l : temp_list)
            {
                if (l.get_course_room().getId() == id_room)
                {
                    throw new IllegalArgumentException(
                            "E' gia' presente una lezione a quest'ora!");
                }
            }
        }
        
        week_day my_day = week_day.valueOf(s_my_day);
        
        ArrayList<LocalTime> vect_h_start = new ArrayList<LocalTime>();
        calendar cal = calendar_dao.get_istance().get_calendar();
        
        LocalTime min_h_start = cal.get_day(my_day).getH_close();
    
        // search next start hour lesson in the same course rooom
        for (int i = 0; i < cal.get_day(my_day).get_lessons().size(); i++)
        {
            if (cal.get_day(my_day).get_lessons().get(i).getH_start()
                    .isAfter(h_start)
                    && cal.get_day(my_day).get_lessons().get(i)
                            .get_course_room().getId() == id_room)
            {
                vect_h_start.add(
                        cal.get_day(my_day).get_lessons().get(i).getH_start());
                
                if (vect_h_start.get(vect_h_start.size() - 1)
                        .isBefore(min_h_start))
                {
                    min_h_start = vect_h_start.get(vect_h_start.size() - 1);
                }
            }
            
        }
        
        // check if insert duration exceed the range //eccolo
        if (h_start.plusMinutes(duration).isAfter(min_h_start)
                && min_h_start != cal.get_day(my_day).getH_close())
        {
            throw new IllegalArgumentException(
                    "La durata della lezione si accavalla con la lezione successiva");
        }
        
        // get the course associated to course_name
        course my_course = new course();
        for (course c : calendar_dao.get_istance().get_courses())
        {
            if (c.getName().equals(course_name))
            {
                my_course.setName(c.getName());
                my_course.setTrainer(c.getTrainer());
                break;
            }
        }
        
        // get the course_room associated to id_room
        course_room my_course_room = new course_room();
        for (course_room r : calendar_dao.get_istance().get_course_rooms())
        {
            if (r.getId() == id_room)
            {
                my_course_room.setId(r.getId());
                my_course_room.setSeats_number(r.getSeats_number());
                break;
            }
        }
        
        lesson new_lesson = new lesson(h_start, duration, my_course,
                my_course_room);
        calendar_dao.get_istance().get_calendar().get_day(my_day).get_lessons()
                .add(new_lesson);
        calendar_dao.get_istance().insert_lesson_dao(new_lesson, my_day);
    }
    
    /**
     * 
     * @param new_course
     */
    public static void insert_course(course new_course)
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione inserisci corso non ancora implementata");
    }
    
    /**
     * 
     * @param day
     *            The choosen day
     * @param old_l
     *            The previous parameters for lesson
     * @param new_l
     *            The new parameters for lesson
     */
    public static void modify_lesson(week_day day, lesson old_l, lesson new_l)
    {
        calendar_dao cal = calendar_dao.get_istance();
        
        boolean found = true;
        ArrayList<lesson> lessons_byday = cal.get_lessons_by_day(day);
        for (int i=0 ; i< lessons_byday.size(); i++)
        {
            if (old_l.equals(lessons_byday.get(i)))
            {
              
                calendar_dao.get_istance().get_calendar().get_day(day).get_lessons()
                .add(i,new_l);
                cal.modify_lesson_dao(day, old_l, new_l);
                found = false;
                break;
            }
        }
        if (found)
        {
            throw new NoSuchElementException(
                    "Impossibile trovare la lezione da modificare");
        }
        
    }
    
    /**
     * @param day
     *            day values are defined in week_day enum and the costant
     *            "tutti"
     * @param name
     *            if name is set null, the lessons will be searched by LocalTime
     * @param h_start
     *            if name is not set null, the lessons will be searched by name
     */
    public static ArrayList<lesson> search_lesson(String day, String name,
            LocalTime h_start)
    {
        ArrayList<lesson> list_searched = new ArrayList<lesson>();
        calendar cal = calendar_dao.get_istance().get_calendar();
        
        if (name == null)
        {
            if (day.equals("tutti"))
            {
                for (int i = 0; i < week_day.values().length; i++)
                    list_searched.addAll(cal.get_day(week_day.values()[i])
                            .search_lessons(h_start));
            }
            else
            {
                list_searched.addAll(cal.get_day(week_day.valueOf(day))
                        .search_lessons(h_start));
            }
            
        }
        else
        {
            if (day.equals("tutti"))
            {
                for (int i = 0; i < week_day.values().length; i++)
                {
                    list_searched.addAll(cal.get_day(week_day.values()[i])
                            .search_lessons(name));
                }
            }
            else
            {
                list_searched.addAll(cal.get_day(week_day.valueOf(day))
                        .search_lessons(name));
            }
            
        }
        return list_searched;
        
    }
    
    /**
     * 
     * @param del_lesson
     */
    public static void delete_lesson(lesson del_lesson)
            throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione rimuovi lezione non ancora implementata");
    }
    
    /**
     * 
     * @param my_day
     */
    public static void modify_hour(day my_day)
            throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione modifica orario non ancora implementata");
    }
    
    /**
     * 
     * @param new_subscriber
     */
    public static void add_subscriber(subscriber new_subscriber)
            throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione aggiungi abbonato non ancora implementata");
    }
    
    /**
     * 
     * @param id_subscriber
     */
    public static void modify_subscriber(int id_subscriber)
            throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione modifica abbonato non ancora implementata");
    }
    
    /**
     * 
     * @param id_subscriber
     */
    public static void delete_subscriber(int id_subscriber)
            throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione rimuovi abbonato non ancora implementata");
    }
    
    public static void search_subscriber() throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione ricerca abbonato non ancora implementata");
    }
    
    /**
     * 
     * @param title
     * @param body
     */
    public static void publish_news(String title, String body)
    {
        board_dao b_dao = board_dao.get_istance();
        b_dao.insert_news(title, body);
        b_dao.get_board().get_news().add(new news(title, body));
    }
    
    public static void contact_support() throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione contatta supporto non ancora implementata");
    }
    
    /**
     * 
     * @param id
     * @param my_course
     */
    public static void subscribe_course(int id, course my_course)
            throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione iscrizione corso non ancora implementata");
    }
    
    public static void read_calendar() throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione iscrizione corso non ancora implementata");
    }
    
    public static void read_news() throws UnsupportedOperationException
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione lettura news non ancora implementata");
    }
    
}
