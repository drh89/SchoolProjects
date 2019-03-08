<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "loginheader.jsp" %>
        <style>
            
            body{
                background-image: url("https://media.altphotos.com/cache/images/2017/04/04/05/1504/baked-cake-turquoise.jpg");
                background-position: 70% 30%;
            }
       
            
        </style>
    <center id="index">
        <form method= "POST" >
            <div>
            Username:<input type ="text" name ="username" value="">
            <br><br>
            Password: <input type ="password" name ="password" value="">
            <br><br>
            <input type="submit" value="Login" formaction="CommandController?command=login">
            <br><br><i>Wrong username or password</i>
            </div>
        </form>
    </body>
</center>
</html>
