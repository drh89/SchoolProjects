/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Bottom;
import logic.CupcakeConnector;
import logic.LineItem;
import logic.ShoppingCart;
import logic.Topping;
import logic.User;

/**
 *
 * @author sofieamalielandt
 */
public class ShopCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            HttpSession session = request.getSession();
            CupcakeConnector cc = new CupcakeConnector();
            List<LineItem> lineitems = new ArrayList<>();
            User user = (User) session.getAttribute("user");
            ShoppingCart shoppingCart = new ShoppingCart(lineitems, user);
            if (session.getAttribute("cart") == null)
            {
                session.setAttribute("cart", shoppingCart);
            }

            if (session.getAttribute("bottoms") == null || session.getAttribute("toppings") == null)
            {
                List<Bottom> bottoms = cc.getCupcakeBottoms();
                session.setAttribute("bottoms", bottoms);
                List<Topping> toppings = cc.getCupcakeToppings();
                session.setAttribute("toppings", toppings);
            }
            
            request.getRequestDispatcher("/shop.jsp").forward(request, response);

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
