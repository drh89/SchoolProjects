<%-- 
    Document   : AddFundsPage
    Created on : 07-03-2019, 22:26:48
    Author     : Dennis
--%>

<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .ccenter{
                position: absolute;
                top: 30%;
                left: 44%;
                
            }
            .ccenter2{
                position: absolute;
                top: 35%;
                left: 44%;
                
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor ="darkviolet">
        <%   User user = (User) session.getAttribute("user");%>
    <center><h1>Add Some Funds</h1></center>
    <div class="ccenter2">
    <form method="GET">
            <br><input type="submit" value="Return to cupcake page" formaction="LoginServlet">
            <input type ="hidden" name ="password" value="<%out.print(user.getPassword());%>">
            <input type ="hidden" name ="email" value="<%out.print(user.getEmail());%>">
        </form>
    </div>
    <div class="ccenter">
        <form method="POST">
        <input placeholder="Funds to add..." type ="text" name ="fundsToAdd" value="">
        <input type="submit" name="valg" value="Add to wallet" formaction="ShopServlet">
        </form>
    </div>
    </body>
</html>
