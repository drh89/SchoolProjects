<%@include file = "loginheader.jsp" %>
        <style>
            
            body{
                background-image: url("https://media.altphotos.com/cache/images/2017/04/04/05/1504/baked-cake-turquoise.jpg");
                background-position: 70% 30%;
            }
       
            
        </style>

    <center id="index">
        
        <div>       
            <form method = "POST">
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
        </div> 
    </center>
</body>
</html>