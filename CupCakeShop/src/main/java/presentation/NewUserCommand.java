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
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            
            User u = new User(username, password, email);
            NewUserController c = new NewUserController();
            
            String res = c.addUser(u);
            
            HttpSession session = request.getSession();
            session.setAttribute("user", u);
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewUser</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>" + res + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            
        }   catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    
    }
    
}
