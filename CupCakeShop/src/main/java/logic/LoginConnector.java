/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.UserMapper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author aamandajuhl
 */
public class LoginConnector
{

    UserMapper um = null;

    public LoginConnector() throws Exception
    {
        um = new UserMapper();
    }

    public boolean isValid(String username, String password) throws Exception
    {
        List<User> users = um.getAllUsers();
        User result = null;

        if (username == null || username.isEmpty()) return false;
        if (password == null || password.isEmpty()) return false;

        for (User u : users)
        {
            if (u.getUserName().equals(username))
            {
                result = u;
            }   
        }
        if(result == null) return false;
        
        else if (result.getPassword().equals(password))
        {
            return true;
        }
        
        return false;
    }
    
    public User getUser(String username) throws SQLException
    {
        return um.getUser(username);
    }

}
