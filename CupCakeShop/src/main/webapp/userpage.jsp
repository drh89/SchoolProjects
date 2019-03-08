<%-- 
    Document   : userpage
    Created on : 06-03-2019, 14:46:32
    Author     : aamandajuhl
--%>

<%@page import="logic.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page import="logic.InvoiceConnector"%>
<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>


<form method="POST">
    <%                out.println("<div style=\" color:Violet; float:right\"><h1> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </h1></div>");
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
        <br><br><b> Your invoices:</b>
        <%
            InvoiceConnector ic = new InvoiceConnector();
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
