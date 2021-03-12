package com.team20.gym_manager;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class B_subscriber
{
    
    public static void subscribe_course()
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione iscrizione corso non ancora implementata");
    }
    
    public static void search_lesson() throws TypeNotPresentException
    {
        Scanner input = new Scanner(System.in);
        System.out.println(
                "\nRicerca delle lezioni per nome del corso o per ora d'inizio?[nome,orario]");
        String answer = input.nextLine();
        System.out.println(
                "Vuoi cercare un giorno in particolare o tutti i giorni?[tutti,lunedi,martedi,...,domenica]:");
        String day = input.nextLine();
        ArrayList<lesson> list_searched = new ArrayList<lesson>();
        switch (answer)
        {
            case "nome" :
                System.out.println(
                        "Inserire nome del corso delle lezioni da ricercare:");
                String name = input.nextLine();
                list_searched = gym_management_system.search_lesson(day, name,
                        null);
                break;
            
            case "orario" :
                System.out.println(
                        "Inserire orario di inizio lezioni:[Formato HH:MM]");
                String start = input.nextLine();
                LocalTime t_start = LocalTime.parse(start);
                list_searched = gym_management_system.search_lesson(day, null,
                        t_start);
                break;
            default :
            input.close();
            throw new TypeNotPresentException("Errore: Il valore inserito non corrisponde a nome o orario.", null); 
        }
        input.close();
        if (list_searched.isEmpty())
        {
            System.out.println(
                    "Non c'è alcuna lezione che corrisponde a questo criterio.\n");
        }
        else
        {
            for (lesson l : list_searched)
            {
                System.out.println("Corso:"+l.get_course().getName()+" Sala n°:"+l.get_course_room().getId()+ "\nInizio: " + l.getH_start() + " Durata: "
                        + l.getDuration() + "\n");
            }
        }
    }
    
    public static void read_calendar()
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione lettura calendario non ancora implementata");
    }
    
    public static void read_news()
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione lettura news non ancora implementata");
    }
    
    public static void contact_support()
    {
        // Function not implemented yet
        throw new UnsupportedOperationException(
                "Funzione contatta supporto non ancora implementata");
    }
    
}
