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
public class NewUserController
{
    
    private UserMapper um = null;

    public NewUserController() throws Exception
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
        if(userExists(user) == true) return "User already exists!";
        um.newUser(user);
        
        return "User is now added";
        
    }
    
    
}
