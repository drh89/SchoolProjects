/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author aamandajuhl
 */
public class LineItem
{
    private int invoice_id;
    private final Cupcake cupcake;
    private int quantity;
    private double price;

    public LineItem(Cupcake cupcake, int quantity)
    {
        this.cupcake = cupcake;
        this.quantity = quantity;
        this.price = cupcake.getPrice() * quantity;
    }

    public int getInvoice_id()
    {
        return invoice_id;
    }

    public Cupcake getCupcake()
    {
        return cupcake;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public void setInvoice_id(int invoice_id)
    {
        this.invoice_id = invoice_id;
    }

    @Override
    public String toString()
    {
        return cupcake + "  " + quantity + "  " + cupcake.getPrice() + "  "+ price;
    }
    
    
    
}
