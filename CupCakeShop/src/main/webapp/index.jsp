<%@include file = "loginheader.jsp" %>
<style>          
    body{
        background-image: url("Images/index_cupcake.jpg");
        background-position: 70% 30%;
    }         
</style>
<center class="index" id="index"> 
    <div>       
        <form method = "POST">
            Username <input type ="text" name ="username" placeholder="username" minlength="4" required>
            <br><br><br>
            Password <input type ="password" name ="password" placeholder="password" minlength="4" required>
            <br><br>
            <button type="submit" formaction="CommandController?command=login">Login</button>
            <br><br><br>
            Email <input type ="text" name ="email" placeholder="username@email.com">
            <br><br>
            <button type="submit" formaction="CommandController?command=newuser">Create user</button>
        </form>   
    </div> 
</center>
</body>
</html>