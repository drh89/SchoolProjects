<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "loginheader.jsp" %>
<style>           
    body{
        background-image: url("Images/index_cupcake.jpg");
        background-position: 70% 30%;
    }
</style>
<center id="index">
    <form method= "POST" >
        <div>
            
            Username <input type ="text" name ="username" value="">
            <br><br>
            Password <input type ="password" name ="password" value="">
            <br><br>
            <input type="submit" value="Login" formaction="CommandController?command=login">
            <br><br>Wrong username or password
        </div>
    </form>
</body>
</center>
</html>
