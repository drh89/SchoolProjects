<%-- 
    Document   : shoppingcart
    Created on : 05-03-2019, 14:24:14
    Author     : aamandajuhl
--%>

<%@page import="logic.ShoppingCart"%>
<%@page import="logic.LineItem"%>
<%@page import="logic.Topping"%>
<%@page import="logic.Bottom"%>
<%@page import="java.util.List"%>
<%@page import="logic.CupcakeController"%>
<%@page import="logic.User"%>
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
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        User user = cart.getUser();
        out.println("<div style=\"float:left\"> Welcome " + user.getUserName() + "</div>");
        out.println("<div style=\"float:right\"> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </div>");
    %>
    <form method = \"GET\">
        <center>
            <br><br><b>Bottoms</b>
            <select name=\"bottom\">
                <%
                    CupcakeController cc = new CupcakeController();
                    List<Bottom> bottoms = cc.getCupcakeBottoms();
                    for (Bottom b : bottoms)
                    {
                        out.println("<option>" + b.toString() + "</option>");
                    }
                %>
            </select>
            &nbsp;&nbsp;
            <b>Toppings</b>
            <select name=\"topping\">
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
            <input type ="text" name ="quantity" value="" size="4" maxlength="3" required><br>
            <br><input type="submit" value="Add to cart" formaction= "CommandController?command=shoppingcart">
        </center>
    </form>
    <br><br><b>Cupcake&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quantity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total&nbsp;&nbsp;&nbsp;&nbsp;Remove</b>    
    <%
        for (LineItem l : cart.getLineItems())
        {
            out.println("<p>" + l + "</p>");
        }
        out.println("<b>Total price: " + cart.getTotalPrice() + "</b>");
    %>
</body>
</html>



