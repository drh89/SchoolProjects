/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.CupcakeMapperFacade;
import logic.Order;
import logic.OrderLine;
import logic.OrderMapperFacade;
import logic.ShoppingCart;
import logic.User;
import logic.UserMapperFacade;

/**
 *
 * @author Dennis
 */
@WebServlet(name = "ShopServlet", urlPatterns = {"/ShopServlet"})
public class ShopServlet extends HttpServlet {

    private OrderMapperFacade omf;
    private UserMapperFacade umf;

    /**
     *
     * @throws Exception
     */
    public ShopServlet() throws Exception {
        omf = new OrderMapperFacade();
        umf = new UserMapperFacade();
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

    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * 
    
     * 
     * 
     */
    
//     * Pages:
//     * index.html
//     * ErrorPageAddCupcake.jsp
//     * UserPaymentPage.jsp
//     * OrderComplete.jsp
//     * AddFundsPage.jsp
//     * FundsAdded.jsp
//     * OrderLineRemoved.jsp
//     * 
//     * Forms:
//     * UserPage.jsp
//     * UserPaymentPage.jsp
//     * AddFundsPage.jsp
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CupcakeMapperFacade cmf = new CupcakeMapperFacade();
            HttpSession session = request.getSession();
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            String valg = request.getParameter("valg");

            User user = (User) session.getAttribute("user");

            switch (valg) {
                
                case "Logout":
                    session.invalidate();
                    response.sendRedirect("index.html");
                    break;

                case "Add to cart":
                    try{

                    if (user.getUserId() == 0) {
                        response.sendRedirect("index.html");
                    }

                    if (request.getParameter("amount").equalsIgnoreCase("") || request.getParameter("amount") == null || Integer.valueOf(request.getParameter("amount")) <= 0 || request.getParameter("bottom").equalsIgnoreCase("")
                            || request.getParameter("topping").equalsIgnoreCase("") ||  request.getParameter("topping") == null || request.getParameter("bottom") == null ) {

                        session.setAttribute("errormessage", "Remember to set an amount of cupcakes");
                        response.sendRedirect("ErrorPageAddCupcake.jsp");
                        return;
                    }} catch(NullPointerException ex){
                        session.setAttribute("errormessage", "Remember to pick a cupcake");
                        response.sendRedirect("ErrorPageAddCupcake.jsp");
                    }

                    int bottomId = Integer.valueOf(request.getParameter("bottom"));
                    int toppingId = Integer.valueOf(request.getParameter("topping"));
                    int amount = Integer.valueOf(request.getParameter("amount"));
                    double price = cmf.getBottomPrice(bottomId) + cmf.getToppingPrice(toppingId);

                    OrderLine orderLine = new OrderLine(amount, price, bottomId, toppingId);
                    omf.writeUnfinishedOrderLine(orderLine, user);

                    cart.getOrderlines().add(orderLine);
                    session.setAttribute("user", user);
                    session.setAttribute("cart", cart);
                    response.sendRedirect("UserPaymentPage.jsp");

                    break;
                case "Checkout":
                    if (user.getUserId() == 0) {
                        response.sendRedirect("index.html");
                    }
                    session.setAttribute("user", user);
                    session.setAttribute("cart", cart);
                    response.sendRedirect("UserPaymentPage.jsp");
                    break;

                case "Buy cupcakes":
                    
                    if (user.getUserId() == 0) {
                        response.sendRedirect("index.html");
                    }
                    double totalPrice = Double.valueOf(request.getParameter("totalprice"));
                    if(user.getBalance() < totalPrice){
                        session.setAttribute("errormessage", "Not enough funds!!!");
                        response.sendRedirect("ErrorPageAddCupcake.jsp");
                        return;
                    }
                    if(totalPrice == 0){
                        session.setAttribute("errormessage", "You need to add some cupcakes!!!");
                        response.sendRedirect("ErrorPageAddCupcake.jsp");
                        return;
                        
                    }
                    Order order = new Order(user.getUserId());
                    omf.createOrder(order, cart);
                    umf.changeBalance(user, totalPrice);
                    
                    response.sendRedirect("OrderComplete.jsp");
                    
                    
                    
                    break;
                
                case "Add funds":
                     if (user.getUserId() == 0) {
                        response.sendRedirect("index.html");
                    }
                    response.sendRedirect("AddFundsPage.jsp");
                    break;
                    
                case "Add to wallet":
                    if (user.getUserId() == 0) {
                        response.sendRedirect("index.html");
                    }
                    if(request.getParameter("fundsToAdd").equalsIgnoreCase("") || Double.valueOf(request.getParameter("fundsToAdd")) <= 0){
                         session.setAttribute("errormessage", "Remember to type how many funds to add...");
                        response.sendRedirect("ErrorPageAddCupcake.jsp");
                        return;
                    }
                    double funds = Double.valueOf(request.getParameter("fundsToAdd"));
                    umf.addToBalance(user, funds);
                    response.sendRedirect("FundsAdded.jsp");
                    break;
                
                    

                case "Remove orderline":
                    if (user.getUserId() == 0) {
                        response.sendRedirect("index.html");
                    }
                    

                    if (request.getParameter("lineId") == null ){
                        session.setAttribute("errormessage", "Please select a cupcake order to remove");
                        response.sendRedirect("ErrorPageAddCupcake.jsp");

                    }
                    int orderLineId = Integer.valueOf(request.getParameter("lineId"));
                    session.setAttribute("message", "Cupcake order succesfully removed");
                    omf.removeUnfinishedOrderLine(orderLineId);
                    cart.setOrderlines(omf.getUnfinishedOrderLines(cart, user));
                    
                    response.sendRedirect("OrderLineRemoved.jsp");

                    break;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
