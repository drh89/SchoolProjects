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
            <div style=float:right><input type ="text" name ="amount" placeholder="Enter amount" size="11" maxlength="3" required>
                <input type="submit" value="Add money to account" formaction="CommandController?command=moneytransfer"></div>
        </form>
        <form method="POST">
            <br><br><div style=float:right><input type="submit" value="Go to shop" formaction="shop.jsp"></div>
        </form>
        <form method ="POST"> 
            <center>
                <br><br><b> Your invoices:</b>
                <%
                    InvoiceController ic = new InvoiceController();
                    List<ShoppingCart> invoices = ic.getInvoices(user.getUserName());
                    for (ShoppingCart invoice : invoices)
                    {
                        out.println("<p><a href=invoice.jsp?selected=" + invoice.getInvoice_id() + ">" + invoice + "</a></p>");
                    }
                %>
            </center>
        </form>

    </body>
</html>
