<%-- 
    Document   : FrontPage
    Created on : 28-02-2019, 14:08:24
    Author     : Dennis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Type in username and password</h1>
        <form method = "GET">
            Username: <input type ="text" name ="username" value="">
            Password: <input type ="text" name ="password" value="">
            <input type="submit" value="Login" formaction="/LoginServlet"
        </form>
    </body>
</html>
