/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.UserMapper;
import java.util.List;

/**
 *
 * @author aamandajuhl
 */
public class NewUserConnector
{
    
    private UserMapper um = null;

    public NewUserConnector() throws Exception
    {
        um = new UserMapper();
    }
 
    public boolean userExists(User user) throws Exception
    {
        List<User> users = um.getAllUsers();
        
        for (User u : users)
        {
            if(u.getUserName().equals(user.getUserName())) return true;
        }        
        return false;
    }
    
    public String addUser(User user) throws Exception
    {
        if(user.getUserName().isEmpty() || user.getUserName() == null) return "Please enter valid username";
        if(user.getPassword().isEmpty() || user.getPassword()== null) return "Please enter valid password";
        if(user.getEmail().isEmpty() || user.getEmail()== null) return "Please enter valid e-mail";
        else if(userExists(user) == true) return "User already exists!";
        
        um.newUser(user);
        return "User is now created";
        
    }
    
    
}
