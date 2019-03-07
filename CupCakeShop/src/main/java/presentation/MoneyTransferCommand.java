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
import logic.User;

/**
 *
 * @author aamandajuhl
 */
public class MoneyTransferCommand extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            HttpSession session = request.getSession();
            Double amount = Double.parseDouble(request.getParameter("amount"));
            User user = (User) session.getAttribute("user");
            user.setBalance(amount);
            
            request.getRequestDispatcher("/userpage.jsp").forward(request, response);
            
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}