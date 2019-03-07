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

    private int invoice_id;
    private List<LineItem> lineItems;
    private double totalPrice;
    private User user;
    private String date;

    public ShoppingCart(List<LineItem> lineitems, User user)
    {
        this.lineItems = lineitems;
        this.totalPrice = calcTotalPrice();
        this.user = user;
        this.invoice_id = invoice_id;
    }

    public ShoppingCart(List<LineItem> lineitems, User user, int invoice_id, String date)
    {
        this.lineItems = lineitems;
        this.totalPrice = calcTotalPrice();
        this.user = user;
        this.invoice_id = invoice_id;
        this.date = date;
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

    public int getInvoice_id()
    {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id)
    {
        this.invoice_id = invoice_id;
    }
    

    public User getUser()
    {
        return user;
    }

    public List<LineItem> getLineItems()
    {
        return lineItems;
    }

    public double getTotalPrice()
    {
        totalPrice = calcTotalPrice();

        return totalPrice;
    }

    public String getDate()
    {
        return date;
    }

    public void addCupcake(LineItem i)
    {
        boolean add = true;

        for (LineItem l : lineItems)
        {
            if (l.getCupcake().compareCupcake(i.getCupcake()))
            {
                add = false;
                l.addQuantity(i.getQuantity());

            }
        }

        if (add)
        {
            lineItems.add(i);
        }
    }
    
    public void removeCupcake(LineItem i)
    {
        lineItems.remove(i);
    }

    @Override
    public String toString()
    {
        return "Ordernumber: " + invoice_id + " " + date;
    }
    
    

}
