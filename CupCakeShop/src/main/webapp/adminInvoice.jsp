<%-- 
    Document   : adminInvoice
    Created on : 07-03-2019, 13:42:38
    Author     : aamandajuhl
--%>

<%@page import="logic.LineItem"%>
<%@page import="logic.ShoppingCart"%>
<%@page import="logic.InvoiceConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice</title>
    </head>
    <body>
        <center>
        <h1 style="color:Violet">Invoice detail</h1>
        <%
            int invoice_id = Integer.parseInt(request.getParameter("selected"));
            InvoiceConnector ic = new InvoiceConnector();
            ShoppingCart invoice = ic.getInvoice(invoice_id);
            out.println("<b>Ordernumber: " + invoice.getInvoice_id() + " Orderdate: " + invoice.getDate() + "</b>");
            out.println("<br><br><i>Username: " + invoice.getUser().getUserName() + " - id: " + invoice.getUser().getId() + "</i>");
            out.println("<br><i>Email: " + invoice.getUser().getEmail() + "</i>");
        %>
        <br><br><br><b>Cupcake&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quantity&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total&nbsp;&nbsp;&nbsp;&nbsp;Remove</b>    
        <%
            for (LineItem l : invoice.getLineItems())
            {
                out.println("<p>" + l + "</p>");
            }
            out.println("<br><br><b>Total order price: " + invoice.getTotalPrice() + "</b>");
        %>
    </center>
    </body>
</html>
