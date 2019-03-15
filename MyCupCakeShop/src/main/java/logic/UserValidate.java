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
public class UserValidate {

    private UserMapper um;

    /**
     *
     * @throws Exception
     */
    public UserValidate() throws Exception {
        um = new UserMapper();
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        UserValidate uv = new UserValidate();

        User user = new User(1, 1, "Dennis", "1234", "test@test.dk", 100.00);

//        System.out.println(uv.userIsValid(user));
    }

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     * 
     * Checks if the user exists in the DB
     */
    public boolean userIsValid(User user) throws SQLException, ClassNotFoundException {

        List<User> users = um.getAllUsers();
        String email = user.getEmail();
        String password = user.getPassword();

        if ("".equalsIgnoreCase(email) || email.isEmpty() || email == null) {
            return false;
        }
        if ("".equalsIgnoreCase(password) || password.isEmpty() || password == null) {
            return false;
        }

        for (User temp : users) {

            if (temp.getEmail().equalsIgnoreCase(email) && temp.getPassword().equalsIgnoreCase(password)) {

                return true;
            }

        }
        return false;
    }

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     * Checks if the user is an admin in the DB
     * 
     */
    public boolean isAdmin(User user) throws SQLException, ClassNotFoundException {
        user = um.getUser(user);

        if (user.getAdminId() == 1) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param user
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * 
     * Checks if the user already exists in the DB, if not, it checks the users parameters to see if they are valid. 
     * 
     */
    public boolean validNewUser(User user) throws SQLException, ClassNotFoundException {

        List<User> users = um.getAllUsers();
        String username = user.getUsername();
        String email = user.getEmail();
        String password = user.getPassword();

        if ("".equalsIgnoreCase(email) || email.isEmpty()) {
            return false;
        }
        if ("".equalsIgnoreCase(username) || username.isEmpty()) {
            return false;
        }
        if ("".equalsIgnoreCase(password) || password.isEmpty()) {
            return false;
        }

        for (User temp : users) {

//            if (temp.getUsername().equalsIgnoreCase(username)) {
//                return false;
//            }
            if (temp.getEmail().equalsIgnoreCase(email)) {
                return false;
            }

        }
        return true;

    }

}
