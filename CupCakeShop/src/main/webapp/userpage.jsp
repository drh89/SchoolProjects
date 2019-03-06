<%-- 
    Document   : userpage
    Created on : 06-03-2019, 14:46:32
    Author     : aamandajuhl
--%>

<%@page import="logic.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page import="logic.InvoiceController"%>
<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User page</title>
    </head>
    <body>
        <form method ="POST">

            <%
                User user = (User) session.getAttribute("user");
                out.println("<div style=\"float:left\"><h1>" + user.getUserName() + "</h1></div>");
                out.println("<div style=\"float:right\"><h1> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </h1></div>");
                out.println("<br><br><br><br><p>Email: " + user.getEmail() + "</p>");
            %>
            <br>
            <%
                
                InvoiceController ic = new InvoiceController();
                List<ShoppingCart> invoices = ic.getInvoices(user.getUserName());
                for (ShoppingCart invoice : invoices)
                {
                    out.println("<p><a href=invoice.jsp?selected=" + invoice.getInvoice_id() + ">" + invoice + "</a></p>");
                }
            %>
        </form>
    </body>
</html>
