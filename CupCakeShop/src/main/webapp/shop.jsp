<%-- 
    Document   : shop
    Created on : 05-03-2019, 13:39:32
    Author     : aamandajuhl and sofieamalielandt
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
<%@include file = "header.jsp" %>

<%  
    CupcakeConnector cc = new CupcakeConnector();
    List<LineItem> lineitems = new ArrayList<>();
    ShoppingCart shoppingCart = new ShoppingCart(lineitems, user);
    session.setAttribute("cart", shoppingCart);
%>
<form method = "POST">
    <center id="shop">
        <div>
            <br><br>Bottoms
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
            Toppings
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
            Quantity
            <input type ="number" name ="quantity" value="1" size="2" min="1" max="100" required><br>
            <br><input type="submit" value="Add to cart" formaction= "shoppingcart.jsp">
        </div>
    </center>
</form>
</body>
</html>



