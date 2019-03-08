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
<%@page import="logic.CupcakeConnector"%>
<%@page import="logic.Bottom"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SWEET RETREAT</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
        body{
            background-image: url("https://media.altphotos.com/cache/images/2017/03/12/09/1504/cupcakes.jpg");
            background-size: cover;
        }
        </style>
        
        
    </head>
    <body>
    <center>
        <h1 style="color:Violet;">SWEET RETREAT</h1>
    </center>
    <%
        User user = (User) session.getAttribute("user");
        List<LineItem> lineitems = new ArrayList<>();
        ShoppingCart shoppingCart = new ShoppingCart(lineitems, user);
        session.setAttribute("cart", shoppingCart);
        
        CupcakeConnector cc = new CupcakeConnector();
        String ref = "userpage.jsp";
        if(user.getType().equals("admin")) ref = "adminpage.jsp";
        out.println("<div style=\"float:left\"> Welcome <a href=" + ref + ">" + user.getUserName() + "</a></div>");
    %>
    <form method = "POST">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Logout" formaction="index.jsp"></form>
    <%
        out.println("<div style=\"float:right\"> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </div>");
    %>
    <form method = "POST">
        <center>
            <br><br><b>Bottoms</b>
            <select name="bottom">
                <option disabled selected>Choose bottom</option>
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
                <option disabled selected>Choose topping</option>
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
            <input type ="number" name ="quantity" value="1" size="2" min="1" max="100" required><br>
            <br><input type="submit" value="Add to cart" formaction= "shoppingcart.jsp">
        </center>
    </form>
</body>
</html>



