package com.team20.gym_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_manager
{
    protected final String url = "tcp://40.114.206.146/~/unina";
    private static db_manager _istance = null;
    private Connection connection;
    
    private db_manager() throws SQLException
    {
    }
    
    private void connect()
    {
        try
        {
            if (connection == null || connection.isClosed())
            {
                
                this.connection = DriverManager.getConnection("jdbc:h2:" + url,
                        "unina", "team20");
            }
        }
        catch (SQLException e)
        {
            System.err.println("Errore instanziamento prima connessioner\n");
            e.printStackTrace();
        }
    }
    
    public static db_manager get_istance()
    {
        if (_istance == null)
        {
            try
            {
                Class.forName("org.h2.Driver");
                _istance = new db_manager();
            }
            catch (SQLException | ClassNotFoundException e)
            {
                System.err.println("Errore instanziamento db_manager\n");
                e.printStackTrace();
            }
        }
        return _istance;
    }
    
    public Connection get_connection()
    {
        connect();
        return connection;
    }
    
    public void close_connection()
    {
        try
        {
            if (connection != null && !connection.isClosed())
            {
                connection.close();
            }
        }
        catch (SQLException e)
        {
            System.err.println("Errore chiusura connessione\n");
            e.printStackTrace();
        }
    }
    
}
