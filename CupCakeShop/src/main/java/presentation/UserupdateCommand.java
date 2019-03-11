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
import logic.LoginConnector;
import logic.User;

/**
 *
 * @author sofieamalielandt
 */
public class UserupdateCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            HttpSession session = request.getSession();
            LoginConnector lc = new LoginConnector();

            String username = request.getParameter("username");
            String oldpassword = request.getParameter("oldpassword");
            String newpassword = request.getParameter("newpassword");
            String email = request.getParameter("email");
            User user = (User) session.getAttribute("user");

            String update = lc.updateUser(user, username, email, newpassword, oldpassword);
            session.setAttribute("update", update);
            session.setAttribute("user ", user);

            request.getRequestDispatcher("/CommandController?command=userinformation").forward(request, response);

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}
