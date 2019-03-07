/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.UserMapper;

/**
 *
 * @author Dennis
 */
public class User
{
    //TEST COMMENT FOR GIT!
    private int id;
    private String userName;
    private String password;
    private String email;
    private double balance;
    private String type;

    public User(int id, String userName, String password, String email, double balance, String type)
    {

        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.balance = balance;
        this.type = type;
    }

    public User(String userName, String password, String email)
    {

        this.userName = userName;
        this.password = password;
        this.email = email;
        this.balance = 0.0;
        this.type = "customer";
    }

    public String getType()
    {
        return type;
    }
    
    public int getId()
    {
        return id;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the balance
     */
    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double money) throws Exception
    {
        UserMapper um = new UserMapper();
        this.balance = balance + money;
        um.updateBalance(id, balance);
    }

    public void pay(double price)
    {
        this.balance = balance - price;
    }
    
    @Override
    public String toString()
    {
        return "User: " + id + ", " + userName + " password: " + password + " email: " + email + " balance: " + balance;
    }

}
