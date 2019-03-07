<%-- 
    Document   : adminpage
    Created on : 07-03-2019, 12:55:04
    Author     : aamandajuhl
--%>

<%@page import="logic.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page import="logic.InvoiceConnector"%>
<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin page</title>
    </head>
    <body>
         <form method ="POST">
            <%
                User user = (User) session.getAttribute("user");
                out.println("<div style=\"color:Violet; float:left\"><h1>" + user.getUserName() + "</h1></div>");
            %>
            <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Logout" formaction="index.jsp">
        </form>
        <form method="POST">
            <%
                out.println("<div style=\" color:Violet; float:right\"><h1> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </h1></div>");
                out.println("<br><br><br><br><br><div style=\"float:left\"><p>Email: " + user.getEmail() + "</p></div>");
            %>
            <br>
            <div style=float:right><input type ="number" name ="amount" placeholder="Enter amount" size="11" min="1" max="1000" required>
                <input type="submit" value="Add money to account" formaction="CommandController?command=moneytransfer"></div>
        </form>
        <form method="POST">
            <br><br><div style=float:right><input type="submit" value="Go to shop" formaction="shop.jsp"></div>
        </form>
        <form method ="POST"> 
            <center>
                <br><br><b> All invoices:</b>
                <%
                    InvoiceConnector ic = new InvoiceConnector();
                    List<ShoppingCart> invoices = ic.getAllInvoices();
                    for (ShoppingCart invoice : invoices)
                    {
                        out.println("<p><a href=adminInvoice.jsp?selected=" + invoice.getInvoice_id() + ">" + invoice + "</a></p>");
                    }
                %>
            </center>
        </form>
    </body>
</html>
