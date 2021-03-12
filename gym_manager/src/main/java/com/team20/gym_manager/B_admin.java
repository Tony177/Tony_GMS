package com.team20.gym_manager;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class B_admin
{
        private static Scanner in = new Scanner(System.in);
        
        public static void insert_lesson()
        {
                
                System.out.println(
                                "Inserire il Nome del Corso della lezione da inserire:");
                String course_name = in.nextLine();
                
                System.out.println(
                                "Inserire l'Orario di Inizio della lezione da inserire [Formato HH:MM]:");
                String s_h_start = in.nextLine();
                LocalTime h_start = LocalTime.parse(s_h_start);
                
                System.out.println(
                                "Inserire il Giorno in cui si vuole inserire della lezione");
                String s_my_day = in.nextLine();
                
                System.out.println(
                                "Inserire il Numero della Sala in cui si deve svolgere la lezione:");
                int id_room = in.nextInt();
                in.nextLine();
                
                System.out.println("Inserire la Durata della lezione:");
                int new_duration = in.nextInt();
                in.nextLine();
                
                gym_management_system.insert_lesson(h_start, new_duration,
                                course_name, id_room, s_my_day);
        }
        
        public static void modify_lesson()
        {
                System.out.println(
                                "Inserire il nome del Corso della lezione da modificare :");
                String course_name = in.nextLine();
                
                System.out.println(
                                "Inserire l'Orario di Inizio della lezione da modificare [Formato HH:MM] :");
                String s_h_start = in.nextLine();
                LocalTime old_h_start = LocalTime.parse(s_h_start);
                
                System.out.println(
                                "Inseriren il Giorno in cui si vuole modificare la lezione :");
                String day_s = in.nextLine();
                System.out.println(
                                "Inserisci l'id della stanza della lezione da modificare:");
                int id_room = in.nextInt();
                
                ArrayList<lesson> find_lessons = gym_management_system
                                .search_lesson(day_s, null, old_h_start);
                lesson old_l = new lesson();
                boolean found = false;
                for (lesson l : find_lessons)
                {
                        if (l.get_course_room().getId() == id_room
                                        && l.get_course().getName()
                                                        .equals(course_name))
                        {
                                old_l = l;
                                found = true;
                                break;
                        }
                }
                if (!found)
                {
                        throw new NoSuchElementException(
                                        "Impossibile trovare la lezione da modificare");
                }

                lesson new_l = new lesson(old_h_start,old_l.getDuration(), old_l.get_course(), old_l.get_course_room());
                //lesson new_l = old_l;
                
                System.out.println("Inserire nuovo orario di inizio [Formato HH:MM] :");
                //String f_h_start = "09:10";
                in.nextLine();
                String f_h_start = in.nextLine();
                LocalTime new_h_start = LocalTime.parse(f_h_start);

                System.out.println(
                                "Inserire la nuova Durata della lezione :");
                int new_duration = in.nextInt();
                
                new_l.setDuration(new_duration);
                
                new_l.setH_start(new_h_start);
               

                gym_management_system.modify_lesson(week_day.valueOf(day_s),
                                old_l, new_l);
                
        }
        
        public static void delete_lesson()
        {
                // Function not implemented yet
                throw new UnsupportedOperationException(
                                "Funzione rimuovi lezione non ancora implementata");
        }
        
        public static void modify_hour()
        {
                // Function not implemented yet
                throw new UnsupportedOperationException(
                                "Funzione modifica orario non ancora implementata");
        }
        
        public static void add_subscriber()
        {
                // Function not implemented yet
                throw new UnsupportedOperationException(
                                "Funzione aggiungi abbonato non ancora implementata");
        }
        
        public static void modify_subscriber()
        {
                // Function not implemented yet
                throw new UnsupportedOperationException(
                                "Funzione modifica abbonato non ancora implementata");
        }
        
        public static void delete_subscriber()
        {
                // Function not implemented yet
                throw new UnsupportedOperationException(
                                "Funzione rimuovi abbonato non ancora implementata");
        }
        
        public static void insert_course()
        {
                // Function not implemented yet
                throw new UnsupportedOperationException(
                                "Funzione inserisci corso non ancora implementata");
        }
        
        public static void publish_news()
        {
                System.out.print("Inserire il titolo: ");
                String title = in.nextLine();
                
                System.out.print("Inserire l'articolo:\n");
                String body = in.nextLine();
                
                gym_management_system.publish_news(title, body);
        }
        
}
