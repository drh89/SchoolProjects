<%-- 
    Document   : invoice
    Created on : 06-03-2019, 14:56:33
    Author     : aamandajuhl and sofieamalielandt
--%>
<%@page import="logic.LineItem"%>
<%@page import="logic.ShoppingCart"%>
<%@page import="logic.InvoiceConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>

<%           
    int invoice_id = Integer.parseInt(request.getParameter("selected"));
    InvoiceConnector ic = new InvoiceConnector();
    ShoppingCart invoice = ic.getInvoice(invoice_id);
%>
<form method="POST">
    <center id="shoppingcart">
        <div>
            <%out.println("<b>Ordernumber: " + invoice.getInvoice_id() + "&nbsp;&nbsp;&nbsp;&nbsp;Orderdate: " + invoice.getDate() + "</b><br><br>");%>
            <table id="shoppingcart"> 
                <tr>
                    <th><b>Cupcake</b></th>
                    <th><b>Quantity</b></th>
                    <th><b>Price</b></th>
                    <th><b>Total</b></th>
                </tr>
                <%
                    for (LineItem l : invoice.getLineItems())
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
                out.println("<br><br><b>Total price: " + invoice.getTotalPrice() + "</b>");
            %>
        </div>
    </center>
</form>
</body>
</html>
