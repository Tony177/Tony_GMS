package com.team20.gym_manager;

import java.util.Scanner;

public class App
{
    private static Scanner in = new Scanner(System.in);
    
    private static void print_welcome()
    {
        System.out
                .println("Benvenuto nel sistema di gestione della palestra.\n");
        System.out.println(
                "Effettuare il login come Abbonato o Amministratore\n");
    }
    
    private static void print_goodbye()
    {
        System.out.println("Arrivederci!");
    }
    
    private static int login_loop()
    {
        int log_code = 0;
        
        while (log_code != 1 && log_code != 2)
        {
            System.out.println("Inserisci Username:");
            String username = in.nextLine();
            System.out.println("Inserisci Password:");
            String password = in.nextLine();
            log_code = user.login(username, password);
            
            switch (log_code)
            {
                case 0 :
                    System.out.println(
                            "Errore: Combinazione di username o password errata.\n");
                    break;
                case 1 :
                    System.out.println(
                            "Autenticazione completata come abbonato.\n");
                    break;
                
                case 2 :
                    System.out.println(
                            "Autenticazione completata come amministratore.\n");
                    break;
                default :
                    break;
            }
        }
        
        return log_code;
    }
    
    private static void admin_menu()
    {
        boolean quit = false;
        
        while (!quit)
        {
            System.out.println(
                    "\nInserisci il numero della funzionalità da utilizzare tra le seguenti\n"
                            + "1. Inserisci abbonato\n"
                            + "2. Modifica abbonato\n" + "3. Elimina abbonato\n"
                            + "4. Inserisci lezione\n" + "5. Modifica lezione\n"
                            + "6. Elimina lezione\n" + "7. Inserisci Corso\n"
                            + "8. Pubblica News\n" + "9. Modifica Orario\n"
                            + "10. Esci dal programma");
            
            int answer = 0;
            
            while (!in.hasNextInt())
            {
                in.nextLine();
            }
            
            answer = in.nextInt();
            in.nextLine();
            try
            {
                switch (answer)
                {
                    case 1 :
                        B_admin.add_subscriber();
                        break;
                    case 2 :
                        B_admin.modify_subscriber();
                        break;
                    case 3 :
                        B_admin.delete_subscriber();
                        break;
                    case 4 :
                        B_admin.insert_lesson();
                        break;
                    case 5 :
                        B_admin.modify_lesson();
                        break;
                    case 6 :
                        B_admin.delete_lesson();
                        break;
                    case 7 :
                        B_admin.insert_course();
                        break;
                    case 8 :
                        B_admin.publish_news();
                        break;
                    case 9 :
                        B_admin.modify_hour();
                        break;
                    case 10 :
                        quit = true;
                        break;
                    default :
                        System.out.println(
                                "Per favore inserisci un valore valido.\n");
                        break;
                    
                }
            }
            catch (UnsupportedOperationException e)
            {
                System.out.println(e.getMessage());
            }
        }
        
    }
    
    private static void user_menu()
    {
        boolean quit = false;
        
        while (!quit)
        {
            System.out.println(
                    "\nInserisci il numero della funzionalità da utilizzare tra le seguenti\n"
                            + "1. Iscriviti ad un corso\n"
                            + "2. Cerca Lezioni\n" + "3. Consulta Calendario\n"
                            + "4. Consulta News\n" + "5. Contatta il Supporto\n"
                            + "6. Esci dal programma");
            
            int answer = 0;
            
            while (!in.hasNextInt())
            {
                in.nextLine();
            }
            
            answer = in.nextInt();
            in.nextLine();
            try
            {
                switch (answer)
                {
                    case 1 :
                        B_subscriber.subscribe_course();
                        break;
                    case 2 :
                        B_subscriber.search_lesson();
                        break;
                    case 3 :
                        B_subscriber.read_calendar();
                        break;
                    case 4 :
                        B_subscriber.read_news();;
                        break;
                    case 5 :
                        B_subscriber.contact_support();
                        break;
                    case 6 :
                        quit = true;
                        break;
                    default :
                        System.out.println(
                                "Per favore inserisci un valore valido.\n");
                        break;
                }
            }
            catch (UnsupportedOperationException e)
            {
                System.out.println(e.getMessage());
            }
            
        }
        
    }
    
    public static void main(String[] args)
    {
        print_welcome();
        
        if (login_loop() == 2)
        {
            admin_menu();
        }
        else
        {
            user_menu();
        }
        
        print_goodbye();
    }
}
