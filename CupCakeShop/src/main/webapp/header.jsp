<%-- 
    Document   : Header
    Created on : 08-03-2019, 12:25:08
    Author     : aamandajuhl
--%>

<%@page import="logic.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">

        <title>SWEET RETREAT</title>
        <style>
            #menu ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #f0d1e0;
                position: fixed;
                top: 0;
                width: 100%;   
            }

            #menu li p 
            {
                float: right;
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;

            }

            #menu li input 
            {
                float: right;
                position: static; width: 100px; 
                display: inline-block;
                align-items: center;
                background-color: #f0d1e0;
                text-decoration: none;
                padding: 30px 20px;
                color: white;
                border: none;

            }

            #menu li button
            {
                float: right;
                display: inline-block;
                text-align: center;
                background-color: #f0d1e0;
                text-decoration: none;
                padding: 30px 20px;
                position: static; width: 150px; 
                color: white;
                border: none;
                font-size: 10px;

            }

            #menu li a{
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 30px 16px;
                text-decoration: none;   
            }

            #menu li a:hover, li button:hover{
                background-color: rgba(239, 116, 172, 1.0);
            }

            #invoice ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                background-color: rgba(239, 209, 224, 0.8);
                width: 25%; 
                border-top-right-radius: 25px;
                border-top-left-radius: 25px;
                border-bottom-right-radius: 25px;
                border-bottom-left-radius: 25px;
            }

            #invoice li h1 
            {
                display: block;
                color: black;
                text-align: center;
                padding: 20px 5px;
                text-decoration: none;
            }

            #invoice li a{
                display: block;
                text-align: center;
                color: black;
                padding: 20px 16px;
                text-decoration: none;   
            }

            #invoice li a:hover{
                background-color: rgba(239, 116, 172, 0.8);
                color: white;
                border-top-right-radius: 25px;
                border-top-left-radius: 25px;
                border-bottom-right-radius: 25px;
                border-bottom-left-radius: 25px;
            }
        </style>

    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String ref = "userpage.jsp";
            if (user.getType().equals("admin"))
            {
                ref = "adminpage.jsp";
            }
        %>
        <form method = "POST">
            <center id="menu">
                <ul>
                    <li> <a class="active" href="shop.jsp"><b> &nbsp;&nbsp; SWEET RETREAT</b></a></li>

                    <li>
                        <%
                            out.println("<a href=" + ref + "><b>" + user.getUserName() + "</b></a>");
                        %>
                    </li>
                    <li><a class="active" href="index.jsp"><b>Logout</b></a></li>
                    <li><p><b>
                                <%
                                    out.println("Balance: " + user.getBalance() + " kr.&nbsp;&nbsp");
                                %>
                            </b> </p></li>
                    <li>
                        <button type="submit" formaction="CommandController?command=moneytransfer">Add money to account</button>          
                        <input type ="number" name ="amount" placeholder="Enter amount" min="1" max="1000" required>

                    </li>

                </ul>
                <br><br><br><br><br><br>    
                <img src="Images/cupcake.png" width="10%" height="10%">
                <br><br>
            </center>
        </form>
