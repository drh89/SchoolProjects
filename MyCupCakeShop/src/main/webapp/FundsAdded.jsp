<%-- 
    Document   : FundsAdded
    Created on : 07-03-2019, 22:55:03
    Author     : Dennis
--%>

<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor = "darkviolet">
        <%   User user = (User) session.getAttribute("user");%> 
    <center><h1>Succes!!!</h1></center>
    <br> Funds added succesfully...
    <form method="GET">
        <br><input type="submit" value="Return to cupcake page" formaction="LoginServlet">
            <input type ="hidden" name ="password" value="<%out.print(user.getPassword());%>">
            <input type ="hidden" name ="email" value="<%out.print(user.getEmail());%>">
        </form>
    </body>
</html>
