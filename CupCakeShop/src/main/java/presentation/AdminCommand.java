/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.util.List;
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
public class AdminCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            HttpSession session = request.getSession();
            InvoiceConnector ic = new InvoiceConnector();
            session.removeAttribute("invoice");

            if (session.getAttribute("allinvoices") == null)
            {
                List<ShoppingCart> invoices = ic.getAllInvoices();
                session.setAttribute("allinvoices", invoices);
            }

            request.getRequestDispatcher("/adminpage.jsp").forward(request, response);

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
