/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.InvoiceMapper;
import data.UserMapper;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sofieamalielandt
 */
public class InvoiceConnector
{
    InvoiceMapper im = null;
    UserMapper um = null;

    public InvoiceConnector() throws Exception
    {
        im = new InvoiceMapper();
        um = new UserMapper();
    }
    
    public String checkout(ShoppingCart cart) throws SQLException
    {
        if(cart.getTotalPrice() <= cart.getUser().getBalance())
        {
            im.newInvoice(cart);
            cart.getUser().pay(cart.getTotalPrice());
            um.updateBalance(cart.getUser().getId(), cart.getUser().getBalance());
            return "Thank you for your order";
        }
        
        return "Your balance is to low, to place the order";
    }
    
    public ShoppingCart getInvoice(int invoice_id) throws Exception
    {
        return im.getInvoice(invoice_id);
    }
    
    public List<ShoppingCart> getInvoices(String username) throws Exception
    {
        return im.getInvoices(username);
    }
    
    public List<ShoppingCart> getAllInvoices() throws Exception
    {
        return im.getAllInvoices();
    }
    
    
}
