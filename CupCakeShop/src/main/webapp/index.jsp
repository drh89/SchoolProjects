<%@include file = "loginheader.jsp" %>
<style>          
    body{
        background-image: url("Images/index_cupcake.jpg");
        background-position: 70% 30%;
    }         
</style>
<center id="index"> 
    <div>       
        <form method = "POST">
            Username <input type ="text" name ="username" value="" minlength="4" required>
            <br><br>
            Password <input type ="password" name ="password" value="" minlength="4" required>
            <br><br>
            <input type="submit" value="Login" formaction="CommandController?command=login">
            <br><br>
            Email <input type ="text" name ="email" value="">
            <br><br>
            <input type="submit" value="Create user" formaction="CommandController?command=newuser">
        </form>   
    </div> 
</center>
</body>
</html>