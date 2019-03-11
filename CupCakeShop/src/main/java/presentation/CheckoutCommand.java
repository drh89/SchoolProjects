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
public class CheckoutCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            InvoiceConnector ic = new InvoiceConnector();
            String checkout = ic.checkout(cart);
            session.setAttribute("checkout", checkout);
            ShoppingCart invoice = null;

            if (checkout.equals("Thank you for your order"))
            {
                invoice = ic.getInvoice(cart.getInvoice_id());
                session.setAttribute("invoice", invoice);
                session.removeAttribute("cart");
            }

            request.getRequestDispatcher("/checkout.jsp").forward(request, response);

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
