<%-- 
    Document   : shoppingcart
    Created on : 05-03-2019, 14:24:14
    Author     : aamandajuhl and sofieamalielandt
--%>

<%@page import="logic.Cupcake"%>
<%@page import="logic.ShoppingCart"%>
<%@page import="logic.LineItem"%>
<%@page import="logic.Topping"%>
<%@page import="logic.Bottom"%>
<%@page import="java.util.List"%>
<%@page import="logic.CupcakeConnector"%>
<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>

<%    Cupcake cupcake = (Cupcake) session.getAttribute("cupcake");
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
%>
<form method = "POST">
    <center id="shop">
        <div>
            <br><br>Bottoms
            <select name="bottom">  
                <option disabled selected>Choose bottom</option>
                <%
                    List<Bottom> bottoms = (List<Bottom>) session.getAttribute("bottoms");
                    for (Bottom b : bottoms)
                    {
                        out.println("<option>" + b.toString() + "</option>");
                    }
                %>
            </select>
            &nbsp;&nbsp;

            Toppings
            <select name="topping"> 
                <option disabled selected>Choose topping</option>
                <%
                    List<Topping> toppings = (List<Topping>) session.getAttribute("toppings");

                    for (Topping t : toppings)
                    {
                        out.println("<option>" + t.toString() + "</option>");
                    }
                %>
            </select>
            &nbsp;&nbsp;

            Quantity
            <input type ="number" name ="quantity" value="1" size="2" min="1" max="100" required><br>
            <br><input type="submit" value="Add to cart" formaction= "CommandController?command=shoppingcart">
            <%
                if (cupcake == null)
                {
                    out.println("<br><br>Please choose a bottom and a topping for your cupcake");
                }
            %>
        </div>
    </center>
</form>
<br><br><br><br>
<center id="shoppingcart">
    <div>
        <table id="shoppingcart"> 
            <tr>
                <th><b>Cupcake</b></th>
                <th><b>Quantity</b></th>
                <th><b>Price</b></th>
                <th><b>Total</b></th>
            </tr>
            <%
                for (LineItem l : cart.getLineItems())
                {
                    out.println("<tr>");
                    out.println("<td>" + l.getCupcake() + "</td>");
                    out.println("<td>" + l.getQuantity() + "</td>");
                    out.println("<td>" + l.getCupcake().getPrice() + "</td>");
                    out.println("<td>" + l.getPrice() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <%
            out.println("<br><br><b>Total price: " + cart.getTotalPrice() + "</b>");
        %>
        <form method = "POST">
            <br><br><input type="submit" value="Checkout" formaction= "CommandController?command=checkout">
        </form>
    </div>
</center>
</body>
</html>



