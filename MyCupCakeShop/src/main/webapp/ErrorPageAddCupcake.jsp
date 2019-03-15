<%-- 
    Document   : ErrorPageAddCupcake
    Created on : 06-03-2019, 19:46:43
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
    <body bgcolor="darkviolet">
        <%

        %>
        <h1>Error!</h1>
        <p><%out.print(session.getAttribute("errormessage")); %>  </p>
        <form method = "GET">
            <%
                User user = (User) session.getAttribute("user");

            %>
            <input type ="hidden" name ="email" value="<%out.print(user.getEmail());%>">
            <input type ="hidden" name ="password" value="<%out.print(user.getPassword());%>">
            <input type="submit" value="Back" formaction="LoginServlet">
        </form>
    </body>
</html>
