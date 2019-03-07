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

/**
 *
 * @author sofieamalielandt
 */
public abstract class Command
{
    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public static Command from(HttpServletRequest request)
    {
        Command c;
        String path = request.getParameter("command");

        switch (path)
        {
            case "login":
                c = new LoginCommand();
                break;

            case "newuser":
                c = new NewUserCommand();
                break;
                
            case "moneytransfer":
                c = new MoneyTransferCommand();
                break;

            default:
                c = new UnknownCommand();
        }

        return c;
    }

}
