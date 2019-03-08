<%-- 
    Document   : Header
    Created on : 08-03-2019, 12:25:08
    Author     : aamandajuhl
--%>

<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">

        <title>SWEET RETREAT</title>
    </head>
    <body>
        <div id="shop">
            <h1> <img src="Images/cupcake.png" width="5%" height="5%"> &nbsp;&nbsp; SWEET RETREAT</h1>
        </div>
        <%
            User user = (User) session.getAttribute("user");
            String ref = "userpage.jsp";
            if (user.getType().equals("admin"))
            {
                ref = "adminpage.jsp";
            }
            out.println("<div style=\"float:left\"> Welcome <a href=" + ref + ">" + user.getUserName() + "</a></div>");
        %>
        <form method = "POST">&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Logout" formaction="index.jsp"></form>
            <%
                out.println("<div> Balance: " + user.getBalance() + " kr.&nbsp;&nbsp </div>");
            %>
        %>