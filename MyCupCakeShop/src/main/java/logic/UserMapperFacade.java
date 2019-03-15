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
 * @author Dennis
 */
public class UserMapperFacade {
    private UserMapper um;

    /**
     *
     * @throws Exception
     */
    public UserMapperFacade() throws Exception {
        um = new UserMapper();
    }
   
    /**
     *
     * @param user
     * @return User from the DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User getUser(User user) throws SQLException, ClassNotFoundException{
        User temp = um.getUser(user);
        
        return temp;
    }
    
    /**
     *
     * @return List of Users from the DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException{
        List<User> users = um.getAllUsers();
        
        return users;
    }
    
    /**
     *
     * @param user
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     * Writes the User to the DB
     * 
     */
    public void newUser(User user) throws SQLException, ClassNotFoundException{
        
        um.newUser(user);
    }

    /**
     *
     * @param user
     * @param totalPrice
     * @throws ClassNotFoundException
     * @throws SQLException
     * 
     * totalPrice is withdrawn from the users balance and updated in the DB
     * 
     */
    public void changeBalance(User user, double totalPrice) throws ClassNotFoundException, SQLException{
        um.changeBalance(user, totalPrice);
    }

    /**
     *
     * @param user
     * @param moneyToAdd
     * @throws ClassNotFoundException
     * @throws SQLException
     * 
     * totalPrice is withdrawn from the users balance and updated in the DB
     * 
     */
    public void addToBalance(User user, double moneyToAdd) throws ClassNotFoundException, SQLException{
        um.addToBalance(user, moneyToAdd);
    }
    
}
