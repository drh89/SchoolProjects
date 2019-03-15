/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Timestamp;

/**
 *
 * @author Dennis
 */
public class OrderLine {
    
    
    
    private int id;
    private int amount;
    private double price;
    private int orderId;
    private int bottomId;
    private int toppingId;
    
    //Variables for view
    private String bottomName;
    private String toppingName;
    private int userId;
    private String orderDate;
    
    
            //For, when getting from DB view

    /**
     *
     * @param bottomName
     * @param toppingName
     * @param amount
     * @param price
     * @param userId
     * @param orderId
     * @param orderDate
     */
    public OrderLine(String bottomName, String toppingName, int amount, double price, int userId, int orderId, String orderDate){
        this.bottomName = bottomName;
        this.toppingName = toppingName;
        this.amount = amount;
        this.price = price;
        this.userId = userId;
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    
            //For, when getting from DB

    /**
     *
     * @param id
     * @param amount
     * @param price
     * @param orderId
     * @param bottomId
     * @param toppingId
     */
    public OrderLine(int id, int amount, double price, int orderId, int bottomId, int toppingId){
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.orderId = orderId;
        this.bottomId = bottomId;
        this.toppingId = toppingId;
    }
    
            //For, when writing to DB

    /**
     *
     * @param amount
     * @param price
     * @param orderId
     * @param bottomId
     * @param toppingId
     */
    public OrderLine(int amount, double price, int orderId, int bottomId, int toppingId ){
        this.amount = amount;
        this.price = price;
        this.orderId = orderId;
        this.bottomId = bottomId;
        this.toppingId = toppingId;
        
    }
            //For, when adding to ShoppingCart

    /**
     *
     * @param id
     * @param amount
     * @param price
     * @param bottomId
     * @param toppingId
     * @throws Exception
     */
    public OrderLine(int id, int amount, double price, int bottomId, int toppingId) throws Exception{
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.bottomId = bottomId;
        this.toppingId = toppingId;
    }       //For when writing to unfinished orders

    /**
     *
     * @param amount
     * @param price
     * @param bottomId
     * @param toppingId
     * @throws Exception
     */
    public OrderLine(int amount, double price, int bottomId, int toppingId) throws Exception{
        
        this.amount = amount;
        this.price = price;
        this.bottomId = bottomId;
        this.toppingId = toppingId;
    }

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
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the bottomId
     */
    public int getBottomId() {
        return bottomId;
    }

    /**
     * @param bottomId the bottomId to set
     */
    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    /**
     * @return the toppingId
     */
    public int getToppingId() {
        return toppingId;
    }

    /**
     * @param toppingId the toppingId to set
     */
    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    /**
     * @return the bottomName
     */
    public String getBottomName() {
        return bottomName;
    }

    /**
     * @param bottomName the bottomName to set
     */
    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }

    /**
     * @return the toppingName
     */
    public String getToppingName() {
        return toppingName;
    }

    /**
     * @param toppingName the toppingName to set
     */
    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
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

//    @Override
//    public String toString() {
//        return "OrderLine{" + "cmf=" + cmf + ", id=" + id + ", amount=" + amount + ", price=" + price + ", orderId=" + orderId + ", bottomId=" + bottomId + ", toppingId=" + toppingId + ", bottomName=" + bottomName + ", toppingName=" + toppingName + ", userId=" + userId + '}';
//    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

   
 
    
    
}
