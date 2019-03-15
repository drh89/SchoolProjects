/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Dennis
 */
public class User {
    
    private int userId;
    private int adminId;
    private String username;
    private String password;
    private String email;
    private double balance;
    
    // Constructor for getting user from DB

    /**
     *
     * @param userId
     * @param adminId
     * @param username
     * @param password
     * @param email
     * @param balance
     */
    public User(int userId, int adminId, String username, String password, String email, double balance){
        this.userId = userId;
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }
    
    //Constructor for writing user to DB

    /**
     *
     * @param username
     * @param password
     * @param email
     */
    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    //Constructor for Logging in

    /**
     *
     * @param email
     * @param password
     */
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    /**
     * @return the id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId
     * @param id the id to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the isAdmin
     */
    public int getAdminId() {
        return adminId;
    }

    /**
     * @param adminId
     * @param isAdmin the isAdmin to set
     */
    public void setIsAdmin(int adminId) {
        this.adminId = adminId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
