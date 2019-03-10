<%-- 
    Document   : checkout
    Created on : 06-03-2019, 12:21:52
    Author     : aamandajuhl and sofieamalielandt
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>

<%    
    ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
    InvoiceConnector ic = new InvoiceConnector();
    String checkout = ic.checkout(cart);
    ShoppingCart invoice = null;

    if (checkout.equals("Thank you for your order"))
    {
        invoice = ic.getInvoice(cart.getInvoice_id());

    }
%>
<form method = "POST">
    <center id="shoppingcart">
        <%        if (checkout.equals("Thank you for your order"))
            {
        %>
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
                }

                out.println("<br><br><i>" + checkout + "</i>");
            %>
            <br><br><input type="submit" value="Keep shopping" formaction= "shop.jsp">
        </div>
    </center>
</form>
</body>
</html>
