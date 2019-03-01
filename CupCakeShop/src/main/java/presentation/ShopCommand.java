/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Bottom;
import logic.CupcakeController;
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
        try {
            CupcakeController cc = new CupcakeController();
            List<Bottom> bottoms = cc.getCupcakeBottoms();
            List<Topping> toppings = cc.getCupcakeToppings();
 
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("<title>JSP Page</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1 style=\"color:MediumSeaGreen;\"> Welcome to the cupcake shop</h1>");
                out.println("<p>User: " + user.getUserName() + "<br>Balance: " + user.getBalance() + " kr.</p>");
                out.println("<br><p> Toppings:" + toppings + "</p>");
                out.println("<p> Bottoms:" + bottoms + "</p>");
                out.println("</body>");
                out.println("</html>");
                
            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }
            //request.getRequestDispatcher("UserPage.jsp").forward(request, response);
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        //request.getRequestDispatcher("UserPage.jsp").forward(request, response);
    }

}
