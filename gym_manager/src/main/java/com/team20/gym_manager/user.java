package com.team20.gym_manager;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class user
{
    
    private String username;
    private String password;
    private String name;
    
    public String getUsername()
    {
        return this.username;
    }
    
    /**
     * 
     * @param username
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getPassword()
    {
        return this.password;
    }
    
    /**
     * 
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    /**
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Login an account and returns an integer that can be [-1,0,+1,+2];
     * 
     * @return
     *         <p>
     *         -1 if there's an error in db connection;
     *         <p>
     *         0 if the combination username-password is wrong;
     *         <p>
     *         +1 if the comination username-password is correct and belongs to
     *         a subscriber
     *         <p>
     *         +2 if the combination username-password is correct and belongs to
     *         a administrator
     * 
     * @param in_username
     *            Input username
     * @param in_password
     *            Input password
     */
    public static int login(String in_username, String in_password)
    {
        Connection conn = db_manager.get_istance().get_connection();
        Statement s = null;
        try
        {
            s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM user");
            while (rs.next())
            {
                if (rs.getString("username").equals(in_username)
                        && rs.getString("password").equals(in_password))
                {
                    if (rs.getString("role").equals("administrator"))
                    {
                        s.close();
                        return 2;
                    }
                    else
                    {
                        s.close();
                        return 1;
                    }
                    
                }
            }
            s.close();
        }
        catch (SQLException e)
        {
            System.err.println(e.getErrorCode());
            System.out.println("Error: Can't connect to DB\n");
            return -1;
        }
        
        return 0;
    }
    
    /**
     * 
     * @param username
     * @param password
     * @param name
     */
    public user(String username, String password, String name)
    {
        this.username = username;
        this.password = password;
        this.name = name;
    }
    public user()
    {
        this.username = null;
        this.password = null;
        this.name = null;
    }
    
}
