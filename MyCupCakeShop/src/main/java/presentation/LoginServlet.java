/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.OrderMapperFacade;
import logic.ShoppingCart;
import logic.User;
import logic.UserMapperFacade;
import logic.UserValidate;

/**
 *
 * @author Dennis
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private UserMapperFacade umf;
    private UserValidate uv;
    private OrderMapperFacade omf;

    /**
     *
     * @throws Exception
     */
    public LoginServlet() throws Exception {
        umf = new UserMapperFacade();
        uv = new UserValidate();
        omf = new OrderMapperFacade();
    }

    /**
     *
     * @param request 
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            loginRequest(request, response);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            newUserRequest(request, response);
        } catch (SQLException ex) {
            ex.getStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.getStackTrace();
        }
    }

    /**
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     * 
    
     * 
     * 
     *  
     */
//    
//     * Called if user is trying to create a new user.
//     * 
//     * Pages:
//     * NewUserPage.jsp
//     * ErrorPageNewUser.jsp
//     * NewUserCreated.jsp
//     * 
//     * Forms:
//     * NewUserPage.jsp
    protected void newUserRequest(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password, email);

        HttpSession session = request.getSession();

        if (!uv.validNewUser(user)) {

            session.setAttribute("errormessage", "invalid username or email, try again");
            response.sendRedirect("ErrorPageNewUser.jsp");
        }

        if (uv.validNewUser(user)) {
            umf.newUser(user);
            response.sendRedirect("NewUserCreatedPage.jsp");
        }

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws Exception
     * 
     * Called if user is trying to log in
     * 
     */
    
//    * Forms:
//     * LoginPage.jsp
//     * ErrorPageAddCupcake.jsp
//     * FundsAdded.jsp
//     * OrderLineRemoved.jsp
//     * OrderComplete.jsp
//     * UserPaymentPage.jsp
//     * AddFundsPage.jsp
//     * 
//     * Pages:
//     * UserPage.jsp
//     * AdminPage.jsp
//     * ErrorPage.jsp
    protected void loginRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
                //Getting parameters from index.html
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(email, password);

        HttpSession session = request.getSession();

        if (!uv.userIsValid(user)) {
            //redirects to ErrorPage
            response.sendRedirect("ErrorPage.jsp");
        }

        if (uv.userIsValid(user)) {
            ShoppingCart cart = new ShoppingCart();
            user = umf.getUser(user);
            cart.setOrderlines(omf.getUnfinishedOrderLines(cart, user)); //Replaces the OrderLine array in cart with new array with the users unfinished orders.
            session.setAttribute("user", user);             //saves the user to the session
            session.setAttribute("cart", cart);             //saves the cart to the session

            if (uv.isAdmin(user)) {
                //Forwards to AdminPage
                session.setAttribute("user", user);

//                request.getRequestDispatcher("AdminPage.jsp").forward(request, response);
                response.sendRedirect("AdminPage.jsp");

            }

            //Forwards to UserPager
            request.getRequestDispatcher("UserPage.jsp").forward(request, response);

        }

    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
