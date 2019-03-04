/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;

/**
 *
 * @author aamandajuhl
 */
public class ShoppingCart
{
    private List<LineItem> lineItems;
    private double totalPrice;
    private User user;

    public ShoppingCart(List<LineItem> lineitems, User user)
    {
        this.lineItems = lineitems;
        this.totalPrice = calcTotalPrice();
        this.user = user;
    }
    
    private double calcTotalPrice()
    {
        double price = 0;
        
        for (LineItem l : lineItems)
        {
            price += l.getPrice();
        }
        
        return price;
    }

    public List<LineItem> getLineItems()
    {
        return lineItems;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }
    
    

   
    
    
    
    
}
