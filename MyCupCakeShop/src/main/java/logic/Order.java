/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Timestamp;
import java.time.LocalDateTime;



/**
 *
 * @author Dennis
 */
public class Order {
    
    private int id;
    private int userId;
    private Timestamp dateAndTime;
    
    
        //For, when getting Order from DB

    /**
     *
     * @param id
     * @param userId
     * @param dateAndTime
     */
    public Order(int id, int userId, Timestamp dateAndTime){
        this.id = id;
        this.userId = userId;
        this.dateAndTime = dateAndTime;
    }
    
    /**
     *
     * @param userId
     */
    public Order(int userId){
        this.userId = userId;
    }
    
    
        //For, when writing Order to DB
//    public Order(int userId){
//        this.userId = userId;
//    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the dateAndTime
     */
    public Timestamp getDateAndTime() {
        return dateAndTime;
    }

    /**
     * @param dateAndTime the dateAndTime to set
     */
    public void setDateAndTime(Timestamp dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    
    @Override
    public String toString(){
        return this.id + " " + this.userId + " " + this.dateAndTime;
    }

   
    
    
    
}
