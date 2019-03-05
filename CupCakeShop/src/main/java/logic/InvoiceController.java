/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.InvoiceMapper;
import java.sql.SQLException;

/**
 *
 * @author sofieamalielandt
 */
public class InvoiceController
{
    InvoiceMapper im = null;

    public InvoiceController() throws Exception
    {
        im = new InvoiceMapper();
    }
    
    public String checkout(ShoppingCart cart) throws SQLException
    {
        if(cart.getTotalPrice() <= cart.getUser().getBalance())
        {
            cart.getUser().pay(cart.getTotalPrice());
            im.newInvoice(cart);
            return "Thank you for your order";
        }
        
        return "Your balance is to low, to place the order";
    }
}
