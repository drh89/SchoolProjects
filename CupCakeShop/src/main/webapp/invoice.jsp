<%-- 
    Document   : invoice
    Created on : 06-03-2019, 14:56:33
    Author     : aamandajuhl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice detail</title>
    </head>
    <body>
        <h1>Invoice detail</h1>
        <%
            String invoice = request.getParameter("selected");
            out.println("<p>" + invoice + "</p>");
            %>
    </body>
</html>
