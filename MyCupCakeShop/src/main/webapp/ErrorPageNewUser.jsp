<%-- 
    Document   : ErrorPageNewUser
    Created on : 03-03-2019, 20:34:24
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
        <p><%out.print(session.getAttribute("errormessage")); %>  </p>
        <p><a href="NewUserPage.jsp" class="linkb" role="button">Back</a></p>
    </body>
</html>
