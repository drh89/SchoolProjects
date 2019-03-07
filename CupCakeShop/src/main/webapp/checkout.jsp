<%-- 
    Document   : checkout
    Created on : 06-03-2019, 12:21:52
    Author     : aamandajuhl
--%>

<%@page import="logic.InvoiceController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.Topping"%>
<%@page import="logic.Bottom"%>
<%@page import="java.util.List"%>
<%@page import="logic.LineItem"%>
<%@page import="logic.User"%>
<%@page import="logic.ShoppingCart"%>
<%@page import="logic.Cupcake"%>
<%@page import="logic.CupcakeController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>THE SWEET CUPCAKE SHOP</title>
    </head>
    <body>
    <center>
        <h1 style="color:Violet;">THE SWEET CUPCAKE SHOP</h1>
    </center>
    <%
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        System.out.println(cart);
        System.out.println(cart.getUser().getId());
        InvoiceController ic = new InvoiceController();
        String checkout = ic.checkout(cart);
        System.out.println(checkout);
        User user = cart.getUser();

        ShoppingCart invoice = ic.getInvoice(cart.getInvoice_id());

        CupcakeController cc = new CupcakeController();

        String ref = "userpage.jsp";
        if(user.getType().equals("admin")) ref = "adminpage.jsp";
        out.println("<div style=\"float:left\"> Welcome <a href=" + ref + ">" + user.getUserName() + "</a></div>");
    %>
    <form method = "POST">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Logout" formaction="index.jsp"></form>
        <%
            out.println("<div style=\"float:right\"> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </div>");
        %>
    <form method = "POST">
        <center>
            <%
                for (LineItem l : invoice.getLineItems())
                {
                    out.println("<p>" + l + "</p>");
                }
                out.println("<b>Total price: " + invoice.getTotalPrice() + "</b><br>");
                out.println("<br><i>" + checkout + "</i>");
            %>
            <br><br><input type="submit" value="Keep shopping" formaction= "shop.jsp">
        </center>
    </form>


</body>
</html>
