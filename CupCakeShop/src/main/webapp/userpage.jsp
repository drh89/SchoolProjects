<%-- 
    Document   : userpage
    Created on : 06-03-2019, 14:46:32
    Author     : aamandajuhl and sofieamalielandt
--%>

<%@page import="logic.ShoppingCart"%>
<%@page import="java.util.List"%>
<%@page import="logic.InvoiceConnector"%>
<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<form method ="POST"> 
    <center id="invoice">
        <ul>
            <li><p><h1>Your invoices</h1></p></li>
            <%            
                InvoiceConnector ic = new InvoiceConnector();
                List<ShoppingCart> invoices = ic.getInvoices(user.getUserName());
                for (ShoppingCart invoice : invoices)
                {
                    out.println("<li><a href=invoice.jsp?selected=" + invoice.getInvoice_id() + ">" + invoice + "</a></li>");
                }
            %>
        </ul>
    </center>
</form>
</body>
</html>
