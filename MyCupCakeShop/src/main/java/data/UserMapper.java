/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logic.User;

/**
 *
 * @author Dennis
 */
public class UserMapper {
    
    
    private DBConnector dbc;
    
    /**
     *
     * @throws Exception
     */
    public UserMapper() throws Exception{
        
        dbc = new DBConnector();
    }
    
    /**
     *
     * @param user
     * @return User from the DB where email and password matches the parameters email and password
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public User getUser(User user) throws SQLException, ClassNotFoundException{
        
        User result = null;
        
        
        
        String query = "SELECT * FROM Users"
                + " WHERE email = '" + user.getEmail()
                + "' AND pass = '" + user.getPassword() + "';";
        
        PreparedStatement stmt = dbc.preparedStatement(query);
        
        ResultSet rs = stmt.executeQuery();
        
        
        while(rs.next()){
            
            int userId = rs.getInt("userId");
            int adminId = rs.getInt("adminId");
            String username = rs.getString("username");
            String password = rs.getString("pass");
            String email = rs.getString("email");
            double balance = rs.getDouble("balance");
            
            result = new User(userId, adminId, username, password, email, balance);
            
        }
        return result;
    }
    
    /**
     *
     * @return List of Users from the DB
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List<User> getAllUsers() throws SQLException, ClassNotFoundException{
        List<User> users = new ArrayList();
        User temp = null;
        
        
        String query = "SELECT * FROM Users;";
        
        PreparedStatement stmt = dbc.preparedStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            
            int userId = rs.getInt("userId");
            int adminId = rs.getInt("adminId");
            String username = rs.getString("username");
            String password = rs.getString("pass");
            String email = rs.getString("email");
            double balance = rs.getDouble("balance");
            
            temp = new User(userId, adminId, username, password, email, balance);
            
            users.add(temp);
            
        }
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
        
        String query = "INSERT INTO Users(adminId, username, pass, email)"
                + " VALUES(?,?,?,?);";
        
        int adminId = 0;
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
                
        PreparedStatement stmt = dbc.preparedStatement(query);
        
        
        stmt.setInt(1, adminId);
        stmt.setString(2, username);
        stmt.setString(3, password);
        stmt.setString(4, email);
        stmt.executeUpdate();
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
        String query = "UPDATE Users SET balance = (?) WHERE userId = (?);";
        
        double finalBalance = user.getBalance() - totalPrice;
        int id = user.getUserId();
        
        PreparedStatement stmt = dbc.preparedStatement(query);
        
        stmt.setDouble(1, finalBalance);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }

    /**
     *
     * @param user
     * @param moneyToAdd
     * @throws ClassNotFoundException
     * @throws SQLException
     * 
     * moneyToAdd is added to the users balance and updated in the DB
     * 
     */
    public void addToBalance(User user, double moneyToAdd) throws ClassNotFoundException, SQLException{
        String query = "UPDATE Users SET balance = (?) WHERE userId = (?);";
        
        double finalBalance = user.getBalance() + moneyToAdd;
        int id = user.getUserId();
        
        PreparedStatement stmt = dbc.preparedStatement(query);
        
        stmt.setDouble(1, finalBalance);
        stmt.setInt(2, id);
        stmt.executeUpdate();
    }
    
    
    public static void main(String[] args) throws Exception {
        UserMapper um = new UserMapper();
        User user = new User("Dennis", "1234", "test@test.dk");
        
        System.out.println(um.getUser(user));
        System.out.println(um.getAllUsers());
    }
}
