/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LoginController;
import logic.User;

/**
 *
 * @author sofieamalielandt
 */
public class LoginCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            LoginController lc = new LoginController();
            HttpSession session = request.getSession();

            boolean valid = lc.isValid(username, password);

            if (valid)
            {
                User user = lc.getUser(username);
                session.setAttribute("user", user);       
                response.sendRedirect("menu");
            }

            if (!valid)
            {
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
                    out.println("Username: <input type =\"text\" name =\"username\" value=\"\"><br>");
                    out.println("<br>Password: <input type =\"text\" name =\"password\" value=\"\">");
                    out.println("<br><br><input type=\"submit\" value=\"Login\" formaction=\"login\">");
                    out.println("<br><br><i>Wrong username or password</i>");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");

                } catch (Exception ex)
                {
                    System.out.println(ex.getMessage());
                }
                //request.getRequestDispatcher("index.html").forward(request, response);
            }

            response.setContentType("text/html;charset=UTF-8");
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
