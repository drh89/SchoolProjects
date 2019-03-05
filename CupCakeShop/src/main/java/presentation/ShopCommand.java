/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Bottom;
import logic.CupcakeController;
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
        
        request.getRequestDispatcher("/shoppingcart.jsp").forward(request, response);
//        try
//        {
////            CupcakeController cc = new CupcakeController();
////            List<Bottom> bottoms = cc.getCupcakeBottoms();
////            List<Topping> toppings = cc.getCupcakeToppings();
//            
////            HttpSession session = request.getSession();
////            User user = (User) session.getAttribute("user");
////            
////            List<LineItem> lineitems = new ArrayList<>();
////            ShoppingCart shoppingcart = new ShoppingCart(lineitems, user);
////            session.setAttribute("cart", shoppingcart);
////
////            response.setContentType("text/html;charset=UTF-8");
////            try (PrintWriter out = response.getWriter())
//            {
//                /* TODO output your page here. You may use following sample code. */
////                out.println("<!DOCTYPE html>");
////                out.println("<html>");
////                out.println("<head>");
////                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
////                out.println("<title>THE SWEET CUPCAKE SHOP</title>");
////                out.println("</head>");
////                out.println("<body>");
////                out.println("<center>");
////                out.println("<h1 style=\"color:Violet;\">THE SWEET CUPCAKE SHOP</h1>");
////                out.println("</center>");
////                out.println("<div style=\"float:left\"> Welcome " + user.getUserName() + "</div>");
////                out.println("<div style=\"float:right\"> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </div>");
////                
////                out.println("<form method = \"GET\">");
////                out.println("<center>");
////                out.println("<br><br><b>Bottoms</b>");
////                out.println("<select name=\"bottom\">");
////                out.println("<option>Choose bottom</option>");
////                for (Bottom b : bottoms)
////                {
////                    out.println("<option>" + b.toString() + "</option>");
////                }
////                out.println("</select>");
////                out.println("&nbsp;&nbsp;");
////                out.println("<b>Toppings</b>");
////                out.println("<select name=\"topping\">");
////                out.println("<option>Choose topping</option>");
////                for (Topping t : toppings)
////                {
////                    out.println("<option>" + t.toString() + "</option>");
////                }
////                out.println("</select>");
////                out.println("&nbsp;&nbsp;");
////                out.println("<b>Quantity</b>");
////                out.println("<input type =\"text\" name =\"quantity\" value=\"\"size=\"4\" maxlength=\"3\" required><br>");
////                out.println("<br><input type=\"submit\" value=\"Add to cart\" formaction=\"shoppingcart\">");
////                out.println("</center>");
////                out.println("</form>");
////                out.println("</body>");
////                out.println("</html>");
//
//            } catch (Exception ex)
//            {
//                System.out.println(ex.getMessage());
//            }
//            //request.getRequestDispatcher("UserPage.jsp").forward(request, response);
//        } catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//        }
//        //request.getRequestDispatcher("UserPage.jsp").forward(request, response);
    }

}
