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
        totalPrice = calcTotalPrice();

        return totalPrice;
    }

    public void addCupcake(LineItem i)
    {
        boolean add = true;

        for (LineItem l : lineItems)
        {
            System.out.println(l.getCupcake().compareCupcake(i.getCupcake()));
            if (l.getCupcake().compareCupcake(i.getCupcake()))
            {
                add = false;
                System.out.println(add);
                l.addQuantity(i.getQuantity());

            }
        }

        if (add)
        {
            System.out.println(add);
            lineItems.add(i);
        }
    }

}
