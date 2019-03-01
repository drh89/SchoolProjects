/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.NewUserController;
import logic.User;

/**
 *
 * @author sofieamalielandt
 */
public class NewUserCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            User u = new User(username, password, email);
            NewUserController c = new NewUserController();

            String res = c.addUser(u);

            //HttpSession session = request.getSession();
            //session.setAttribute("user", u);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Start Page</title>");
                out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Type in username and password</h1>");
                out.println("<body>");
                out.println("<form method = \"GET\">");
                out.println("<i>Welcome " + u.getUserName() + "</i>");
                out.println("<br><i>" + res + "</i><br><br>");
                out.println("Username: <input type =\"text\" name =\"username\" value=\"\"><br>");
                out.println("<br>Password: <input type =\"text\" name =\"password\" value=\"\">");
                out.println("<br><br><input type=\"submit\" value=\"Login\" formaction=\"login\">");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");

            } catch (Exception ex)
            {
                System.out.println(ex.getMessage());
            }

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}
