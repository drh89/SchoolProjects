<%-- 
    Document   : LoginPage
    Created on : 03-03-2019, 21:05:04
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
        <h1>Type in username and password</h1>
        <form method = "GET">
             <input placeholder="Enter email" type ="text" name ="email" value="">
             <input placeholder="Enter password" type ="text" name ="password" value="">
            <input type="submit" value="Login" formaction="LoginServlet">
            <p><a href="NewUserPage.jsp" class="linkb" role="button">Create new user</a></p>
            
    </body>
</html>
