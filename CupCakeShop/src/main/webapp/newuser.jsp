<%-- 
    Document   : newuser
    Created on : 05-03-2019, 15:13:07
    Author     : aamandajuhl and sofieamalielandt
--%>

<%@page import="logic.User"%>
<%@page import="logic.NewUserConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "loginheader.jsp" %>
<style>
    body{
        background-image: url("https://media.altphotos.com/cache/images/2017/04/04/05/1504/baked-cake-turquoise.jpg");
        background-position: 70% 30%;
    }
</style>
<center id="index">
    <form method = "POST">   
        <%
            String res = (String) session.getAttribute("res");
        %>  
        <div>
            Username <input type ="text" name ="username" value="" minlength="4" required>
            <br><br>
            Password <input type ="password" name ="password" value="" minlength="4" required>
            <br><br>
            <input type="submit" value="Login" formaction="CommandController?command=login">
            <br><br>
            Email <input type ="text" name ="email" value="">
            <br><br>
            <input type="submit" value="Create user" formaction="CommandController?command=newuser">
            <%
                out.println("<br><br>" + res + "<br>");
            %>
        </div>
    </form>
</center>
</body>
</html>



