<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            div{
                border-style: solid;
                border-color: #ffe8ff;
                border-top-right-radius: 25px;
                border-top-left-radius: 25px;
                border-bottom-right-radius: 25px;
                border-bottom-left-radius: 25px;
                padding: 25px;
                box-sizing: border-box;
                width: 300px;
                height: 230px;

            }
            body{
                background-image: url("https://media.altphotos.com/cache/images/2017/04/04/05/1504/baked-cake-turquoise.jpg");
                background-position: 70% 30%;
            }
       
            
        </style>

    </head>
    <body>
    <center>
        <h1 style="color:#ffe8ff"> WELCOME TO SWEET RETREAT</h1>
        <img scr='/Images/Cupcake.jpg.png'>
        <h3 style="color:#ffe8ff">Type in username and password</h3> 
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