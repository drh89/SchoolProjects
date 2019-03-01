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
import logic.LoginController;

/**
 *
 * @author sofieamalielandt
 */
public class LoginCommand extends Command
{

    public LoginCommand()
    {
    }

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

            if (lc.isValid(username, password))
            {

                session.setAttribute("username", username);

                request.getRequestDispatcher("UserPage.jsp").forward(request, response);

            }

            if (!lc.isValid(username, password))
            {
                request.getRequestDispatcher("index.html").forward(request, response);
            }

            response.setContentType("text/html;charset=UTF-8");
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
