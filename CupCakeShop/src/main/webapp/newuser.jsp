<%-- 
    Document   : newuser
    Created on : 05-03-2019, 15:13:07
    Author     : aamandajuhl
--%>

<%@page import="logic.User"%>
<%@page import="logic.NewUserController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center>
        <h1>Type in username and password</h1>
        <form method = "POST">
            <%
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");

                User u = new User(username, password, email);
                NewUserController c = new NewUserController();
                String res = c.addUser(u);
                out.println("<br><i>" + res + "</i><br><br>");
            %>
            Username: <input type ="text" name ="username" value="" minlength="4" required>
            <br><br>
            Password: <input type ="password" name ="password" value="" minlength="4" required>
            <br><br>
            <input type="submit" value="Login" formaction="CommandController?command=login">
            <br><br>
            Email: <input type ="text" name ="email" value="">
            <br><br>
            <input type="submit" value="Create user" formaction="CommandController?command=newuser">
        </form>
    </center>
    </body>
</html>



