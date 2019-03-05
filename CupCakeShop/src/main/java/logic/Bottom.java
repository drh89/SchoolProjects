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
public class Bottom
{

    private int bottom_id;
    private String flavour;
    private double price;

    public Bottom(int bottom_id, String flavour, double price)
    {
        this.bottom_id = bottom_id;
        this.flavour = flavour;
        this.price = price;
    }

    public int getBottom_id()
    {
        return bottom_id;
    }

    /**
     * @return the flavour
     */
    public String getFlavour()
    {
        return flavour;
    }

    /**
     * @param flavour the flavour to set
     */
    public void setFlavour(String flavour)
    {
        this.flavour = flavour;
    }

    /**
     * @return the price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return flavour + " " + price + " kr";
    }
}
