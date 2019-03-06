<%-- 
    Document   : shop
    Created on : 05-03-2019, 13:39:32
    Author     : aamandajuhl
--%>

<%@page import="logic.ShoppingCart"%>
<%@page import="logic.LineItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.Topping"%>
<%@page import="logic.User"%>
<%@page import="java.util.List"%>
<%@page import="logic.CupcakeController"%>
<%@page import="logic.Bottom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>THE SWEET CUPCAKE SHOP</title>
    </head>
    <body>
    <center>
        <h1 style="color:Violet;">THE SWEET CUPCAKE SHOP</h1>
    </center>
    <%
        User user = (User) session.getAttribute("user");
        List<LineItem> lineitems = new ArrayList<>();
        ShoppingCart shoppingCart = new ShoppingCart(lineitems, user);
        session.setAttribute("cart", shoppingCart);

        CupcakeController cc = new CupcakeController();

        out.println("<div style=\"float:left\"> Welcome " + user.getUserName() + "</div>");
        out.println("<div style=\"float:right\"> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </div>");
    %>
    <form method = "POST">
        <center>
            <br><br><b>Bottoms</b>
            <select name="bottom">
                <option>Choose bottom</option>
                <%
                    List<Bottom> bottoms = cc.getCupcakeBottoms();
                    for (Bottom b : bottoms)
                    {
                        out.println("<option>" + b.toString() + "</option>");
                    }
                %>
            </select>
            &nbsp;&nbsp;
            <b>Toppings</b>
            <select name="topping">
                <option>Choose topping</option>
                <%
                    List<Topping> toppings = cc.getCupcakeToppings();
                    for (Topping t : toppings)
                    {
                        out.println("<option>" + t.toString() + "</option>");
                    }
                %>
            </select>
            &nbsp;&nbsp;
            <b>Quantity</b>
            <input type ="text" name ="quantity" value=""size="4" maxlength="3" required><br>
            <br><input type="submit" value="Add to cart" formaction= "shoppingcart.jsp">
        </center>
    </form>
</body>
</html>



