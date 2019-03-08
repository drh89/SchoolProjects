<%-- 
    Document   : checkout
    Created on : 06-03-2019, 12:21:52
    Author     : aamandajuhl
--%>

<%@page import="logic.InvoiceConnector"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.Topping"%>
<%@page import="logic.Bottom"%>
<%@page import="java.util.List"%>
<%@page import="logic.LineItem"%>
<%@page import="logic.User"%>
<%@page import="logic.ShoppingCart"%>
<%@page import="logic.Cupcake"%>
<%@page import="logic.CupcakeConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>

<%        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
    InvoiceConnector ic = new InvoiceConnector();
    String checkout = ic.checkout(cart);
    ShoppingCart invoice = null;

    if (checkout.equals("Thank you for your order"))
    {
        invoice = ic.getInvoice(cart.getInvoice_id());

    }
    CupcakeConnector cc = new CupcakeConnector();


%>
<form method = "POST">
    <center>
        <%                if (checkout.equals("Thank you for your order"))
            {
                for (LineItem l : invoice.getLineItems())
                {
                    out.println("<p>" + l + "</p>");
                }
                out.println("<b>Total price: " + invoice.getTotalPrice() + "</b><br>");
            }
            out.println("<br><i>" + checkout + "</i>");

            if (checkout.equals("Your balance is to low, to place the order"))
            {
                out.println("<br><br><input type=\"submit\" value=\"Add money to your account\" formaction= \"" + ref + "\">");
            }
        %>
        <br><br><input type="submit" value="Keep shopping" formaction= "shop.jsp">
    </center>
</form>


</body>
</html>
