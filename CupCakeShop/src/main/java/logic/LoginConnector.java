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
 * @author aamandajuhl and sofieamalielandt
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

        if (username == null || username.isEmpty())
        {
            return false;
        }
        if (password == null || password.isEmpty())
        {
            return false;
        }

        for (User u : users)
        {
            if (u.getUserName().equals(username))
            {
                result = u;
            }
        }
        if (result == null)
        {
            return false;
        } else if (result.getPassword().equals(password))
        {
            return true;
        }

        return false;
    }

    public User getUser(String username) throws SQLException
    {
        return um.getUser(username);
    }

    public String updateUser(User user, String username, String email, String newpassword, String oldpassword) throws SQLException, Exception
    {
        boolean notInUse = true;
        boolean valid = false;
        List<User> users = um.getAllUsers();

        for (User u : users)
        {
            if (u.getUserName().equals(username))
            {
                if (u.getId() != user.getId())
                {
                    notInUse = false;
                }
            }

            if (u.getId() == user.getId())
            {
                if (u.getPassword().equals(oldpassword) && newpassword.equals(u.getPassword()))
                {
                    valid = true;
                } else if (u.getPassword().equals(oldpassword))
                {
                    user.setPassword(newpassword);
                    valid = true;
                }
            }
        }

        if (notInUse && valid)
        {
            user.setUserName(username);
            user.setEmail(email);
            um.updateUser(user);
            return "Information saved";

        } else if (notInUse && !valid)
        {
            return "Wrong password";
        }

        return "Username already in use";
    }

}
