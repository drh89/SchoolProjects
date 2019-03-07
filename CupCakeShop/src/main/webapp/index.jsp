<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
    <center>
        <h1 style="color:Violet">Type in username and password</h1>
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
    </center>
    </body>
</html>