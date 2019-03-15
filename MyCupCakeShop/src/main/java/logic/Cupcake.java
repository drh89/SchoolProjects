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
public class Cupcake {
    
    private int id;
    private Bottom bottom;
    private Topping topping;
    private double price;
    
    /**
     *
     * @param id
     * @param bottom
     * @param topping
     * @param price
     */
    public Cupcake(int id, Bottom bottom, Topping topping, double price){
        this.id = id;
        this.bottom = bottom;
        this.topping = topping;
        this.price = bottom.getPrice() + topping.getPrice();
    }

    /**
     * @return the bottom
     */
    public Bottom getBottom() {
        return bottom;
    }

    /**
     * @param bottom the bottom to set
     */
    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    /**
     * @return the topping
     */
    public Topping getTopping() {
        return topping;
    }

    /**
     * @param topping the topping to set
     */
    public void setTopping(Topping topping) {
        this.topping = topping;
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
}
