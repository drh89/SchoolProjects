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
import logic.NewUserConnector;
import logic.User;

/**
 *
 * @author aamandajuhl and sofieamalielandt
 */
public class NewUserCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        try
        {
            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            
            User u = new User(username, password, email);
            NewUserConnector c = new NewUserConnector();
            String res = c.addUser(u);
            session.setAttribute("res", res);
            
            request.getRequestDispatcher("/newuser.jsp").forward(request, response);
            
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
