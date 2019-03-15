<%-- 
    Document   : NewUserPage
    Created on : 03-03-2019, 20:22:21
    Author     : Dennis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .linkb{
                color: white;
            }
        </style>
    </head>
    <body bgcolor="darkviolet">
        <h1>Type in email, username and password</h1>
        <form method = "POST">
            <input placeholder="Email" type ="text" name ="email" value="">
            <input placeholder="Username" type="text" name ="username" value="">
            <input placeholder="Password" type ="text" name ="password" value="">
            
            <p><input type="submit" value="Create new user" formaction="LoginServlet"></p>
            <p></p>
            <p> <a href="LoginPage.jsp" class="linkb" role="button">Back to Login</a></p>
    </body>
</html>
