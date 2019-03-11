/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.InvoiceConnector;
import logic.ShoppingCart;

/**
 *
 * @author sofieamalielandt
 */
public class InvoiceCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            HttpSession session = request.getSession();
            int invoice_id = Integer.parseInt(request.getParameter("selected"));
            InvoiceConnector ic = new InvoiceConnector();
            ShoppingCart invoice = ic.getInvoice(invoice_id);
            session.setAttribute("invoice", invoice);
            
            request.getRequestDispatcher("/invoice.jsp").forward(request, response);
            
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
