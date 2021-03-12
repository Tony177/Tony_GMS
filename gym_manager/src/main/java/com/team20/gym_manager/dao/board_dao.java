package com.team20.gym_manager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team20.gym_manager.board;
import com.team20.gym_manager.db_manager;

/**
 * board_dao This class helps handling the board sync with the database. Its
 * implemented as a Singleton
 */
public class board_dao
{
    
    private static board_dao istance = null;
    private board news_board = new board();
    
    private void download_board()
    {
        try
        {
            ResultSet rs = db_manager.get_istance().get_connection()
                    .createStatement().executeQuery("SELECT * FROM board");
            while (rs.next())
            {
                news_board.create_news(rs.getString("title"),
                        rs.getString("body"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public board_dao()
    {
    }
    
    public static board_dao get_istance()
    {
        if (istance == null)
        {
            istance = new board_dao();
        }
        
        return istance;
    }
    
    /**
     * Returs a new's board that is initalizated from the database. The board is
     * initalizated only on the first call of this method, than returns a cashed
     * version
     *
     * @return the downloaded board
     */
    public board get_board()
    {
        if (news_board.get_news().size() == 0)
        {
            download_board();
        }
        
        return news_board;
    }
    
    /**
     * Create and inserts into the database a news
     * 
     * @param title
     *            article's title
     * @param body
     *            article's body
     */
    public void insert_news(String title, String body)
    {
        if (news_board.get_news().size() != 0)
        {
            news_board.create_news(title, body);
        }
        
        try
        {
            PreparedStatement ps = db_manager.get_istance().get_connection()
                    .prepareStatement("INSERT INTO board VALUES(?,?)");
            
            ps.setString(1, title);
            ps.setString(2, body);
            
            ps.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
