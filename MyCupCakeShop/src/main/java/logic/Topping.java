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
public class Topping {
    
    private int id;
    private String flavour;
    private double price;
    
    /**
     *
     * @param id
     * @param flavour
     * @param price
     */
    public Topping(int id, String flavour, double price){
        this.id = id;
        this.flavour = flavour;
        this.price = price;
    }

    /**
     * @return the flavour
     */
    public String getFlavour() {
        return flavour;
    }

    /**
     * @param flavour the flavour to set
     */
    public void setFlavour(String flavour) {
        this.flavour = flavour;
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
    @Override
    public String toString(){
        
        return this.flavour + " " + this.price + " kr";
    }
    
}
