<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Error Page</title>
        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">
    </head>

    <body>
    <center>
        <h1> Type in username and password </h1>
        <form method= "POST" >
            Username:<input type ="text" name ="username" value="">
            <br><br>
            Password: <input type ="password" name ="password" value="">
            <br><br>
            <input type="submit" value="Login" formaction="CommandController?command=login">
            <br><br><i>Wrong username or password</i>
        </form>
    </body>
</center>
</html>
