/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Cupcake;
import logic.CupcakeConnector;
import logic.LineItem;
import logic.ShoppingCart;

/**
 *
 * @author sofieamalielandt
 */
public class ShoppingcartCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {

            HttpSession session = request.getSession();
            String bottom = request.getParameter("bottom");
            String topping = request.getParameter("topping");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            if (bottom != null && topping != null)
            {
                CupcakeConnector cc = new CupcakeConnector();
                Cupcake cupcake = cc.getCupCake(bottom, topping);
                ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

                if (cupcake != null)
                {
                    cart.addCupcake(new LineItem(cupcake, quantity));
                    request.getRequestDispatcher("/shoppingcart.jsp").forward(request, response);
                } 

            }
            
            else if (bottom == null || topping == null)
                {
                    String reply = "Please choose a bottom and a topping for your cupcake";
                    session.setAttribute("reply", reply);
                    request.getRequestDispatcher("/shop.jsp").forward(request, response);
                }
            else
            {
                request.getRequestDispatcher("/shoppingcart.jsp").forward(request, response);
            }

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
