/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import logic.User;

/**
 *
 * @author sofieamalielandt
 */
public class UserMapper
{

    private DBConnector connector = null;

    public UserMapper() throws Exception
    {
        this.connector = new DBConnector();
    }

    public User getUser(String username) throws SQLException
    {
        String query
                = "SELECT * "
                + "FROM Cupcakes.user "
                + "WHERE username = '" + username + "';";

        PreparedStatement statement = connector.getConnection().prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        User user = null;
        int id = 0;
        String name = "";
        String password = "";
        String email = "";
        double balance = 0;

        while (rs.next())
        {
            id = rs.getInt("user_id");
            name = rs.getString("username");
            password = rs.getString("password");
            email = rs.getString("email");
            balance = rs.getDouble("balance");

            if (rs.getString("username") == null)
            {
                return null;
            }

            user = new User(id, name, password, email, balance);
        }

        return user;
    }

    public void newUser(User newUser) throws SQLException
    {
        String query = "INSERT INTO Cupcakes.user"
                + "(`username`, `password`, `email`)"
                + "VALUES (?,?,?);";

        String username = newUser.getUserName();
        String password = newUser.getPassword();
        String email = newUser.getEmail();

        PreparedStatement statement = connector.getConnection().prepareStatement(query);

        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, email);
        statement.executeUpdate();

    }

    public List<User> getAllUsers() throws Exception
    {

        List<User> users = new ArrayList();

        String query = "SELECT * FROM user";

        int id = 0;
        String userName = "";
        String password = "";
        String email = "";
        double balance = 0.0;

        PreparedStatement stmt = connector.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next())
        {

            id = rs.getInt("user_id");
            userName = rs.getString("username");
            password = rs.getString("password");
            email = rs.getString("email");
            balance = rs.getDouble("balance");

            User user = new User(id, userName, password, email, balance);
            users.add(user);

        }
        return users;
    }

    public static void main(String[] args) throws Exception
    {
        UserMapper um = new UserMapper();
        System.out.println(um.getAllUsers());
    }
}
