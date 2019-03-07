<%-- 
    Document   : shoppingcart
    Created on : 05-03-2019, 14:24:14
    Author     : aamandajuhl
--%>

<%@page import="logic.Cupcake"%>
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
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CupcakeController cc = new CupcakeController();

        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        User user = cart.getUser();

        Cupcake cupcake = cc.getCupCake(bottom, topping);
        String ref = "userpage.jsp";
        if (user.getType().equals("admin")) ref = "adminpage.jsp";
        out.println("<div style=\"float:left\"> Welcome <a href=" + ref + ">" + user.getUserName() + "</a></div>");

    %>
    <form method = "POST">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Logout" formaction="index.jsp"></form>
        <%        out.println("<div style=\"float:right\"> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </div>");
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
            <input type ="number" name ="quantity" value="1" size="2" maxlength="3" required><br>
            <br><input type="submit" value="Add to cart" formaction= "shoppingcart.jsp">
            <%
                if (cupcake == null)
                {
                    out.println("<br><br><i>Please choose a bottom and a topping for your cupcake</i>");
                } else
                {
                    cart.addCupcake(new LineItem(cupcake, quantity));
                }
            %>
        </center>
        <br><br><b>Cupcake&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quantity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total&nbsp;&nbsp;&nbsp;&nbsp;Remove</b>    
        <%
            for (LineItem l : cart.getLineItems())
            {
                out.println("<p>" + l + "</p>");
            }
            out.println("<br><br><b>Total price: " + cart.getTotalPrice() + "</b>");
        %>
    </form>
    <form method = "POST">
        <br><br><input type="submit" value="Checkout" formaction= "checkout.jsp">
    </form>
</body>
</html>



