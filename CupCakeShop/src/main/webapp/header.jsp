<%-- 
    Document   : Header
    Created on : 08-03-2019, 12:25:08
    Author     : aamandajuhl and sofieamalielandt
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
            .menu ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                overflow: hidden;
                background-color: #f0d1e0;
                position: fixed;
                top: 0;
                width: 100%;  
                height: 80px;
                font-family: HelveticaNeue-Thin;
            }
            .menu li p {
                float: right;
                display: block;
                color: white;
                text-align: center;
                padding: 15px 16px;
                text-decoration: none;
                height: 80px;
            }
            .menu li input {
                float: right;
                position: static; width: 100px; 
                display: inline-block;
                align-items: center;
                background-color: #f0d1e0;
                text-decoration: none;
                padding: 0px 20px;
                color: white;
                border: none;
                height: 80px;
                font-family: HelveticaNeue-Thin;
                font-size: 15px;
            }

            .menu li button {
                float: right;
                display: inline-block;
                text-align: center;
                background-color: #f0d1e0;
                text-decoration: none;
                padding: 20px 20px;
                position: static; width: 150px; 
                color: white;
                border: none;
                font-family: HelveticaNeue-Thin;
                font-size: 15px;
                height: 80px;
            }
            .menu li a {
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 0px 16px;
                text-decoration: none;  
                height: 80px;
                display: -webkit-flex;
                -webkit-align-items: center; 
            }
            .menu li a img {
                display: block;
                text-align: center;
                color: black;
                padding: 0px 0px;
                width: 40px;
                height: 50px;
                text-decoration: none;  
                display: -webkit-flex;
                -webkit-align-items: center; 
            }

            .menu li a:hover, li input:hover, .dropdown:hover {
                background-color: rgba(239, 116, 172, 1.0);
                color: white;
            }

            .menu button:hover {
                background-color: rgba(239, 116, 172, 1.0);
                color: white;
                border-radius: 0px;
            }

            #shop input, select, button {
                position: static; width: auto; 
                display: inline-block;
                align-items: center;
                background-color: transparent;
                text-decoration: none;
                border: none;
                font-family: HelveticaNeue-Thin;
                font-size: 16px;
                text-align: center;
            }
            

            #shop input:hover {
                background-color: rgba(239, 116, 172, 1.0);
                color: white;
                border-radius: 25px;
                padding: 2px 2px;
            }
            
            #shop select:hover, button:hover {
                background-color: rgba(239, 116, 172, 1.0);
                color: white;
                border-radius: 25px;
                padding: 10px 10px;
            }

            #checkout input, button {
                position: static; width: auto; 
                display: inline-block;
                align-items: center;
                background-color: transparent;
                text-decoration: none;
                border: none;
                font-family: HelveticaNeue-Thin;
                font-size: 16px;
                text-align: center;
            }

            #checkout input:hover, button:hover {
                background-color: rgba(239, 116, 172, 1.0);
                color: white;
                border-radius: 25px;
                padding: 10px 10px;
            }
            .dropdown-content {
                display: none;
                position: relative;
                min-width: 100px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 5;
            }

            .dropdown:hover .dropdown-content {
                display: list-item;
            }

            #cart li a img {
                display: block;
                text-align: center;
                color: black;
                padding: 0px 8px;
                width: 34px;
                height: 30px;
                text-decoration: none;  
                display: -webkit-flex;
                -webkit-align-items: center; 
            }

            #invoice ul {
                list-style-type: none;
                margin: 0;
                padding: 0;
                background-color: rgba(239, 209, 224, 0.8);
                width: 25%; 
                border-radius: 12px;
                font-family: HelveticaNeue-Thin;
            }
            #invoice li h1 {
                display: block;
                color: black;
                text-align: center;
                padding: 20px 5px;
                text-decoration: none;
            }
            #invoice li a {
                display: block;
                text-align: center;
                color: black;
                padding: 20px 16px;
                text-decoration: none;   
            }
            #invoice li a:hover {
                background-color: rgba(239, 116, 172, 0.8);
                color: white;
                border-radius: 25px;
            }
        </style>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String ref = "CommandController?command=user";
            if (user.getType().equals("admin"))
            {
                ref = "CommandController?command=admin";
            }
        %>
        <form method = "POST">
            <center class="menu">
                <ul>
                    <li> <a class="active" href="CommandController?command=shop"><img src="Images/cupcake.png"></a></li>
                    <li class="dropdown">
                        <%
                            out.println("<a href=\"javascript:void(0)\">" + user.getUserName() + "</a>");
                        %>
                        <div class="dropdown-content">
                            <a href="CommandController?command=userinformation">Information</a>
                            <%out.println("<a href=" + ref + ">Invoices</a>");%>

                        </div>
                    </li>
                    <li><a class="active" href="index.jsp">Logout</a></li>
                    <center id="cart">
                        <li id="cart"><a class="active" href="shoppingcart.jsp"><img src="Images/shoppingcart.png" width="5%" height="5%"></a></li>
                    </center>
                    <li><p>
                            <%
                                out.println("Balance: " + user.getBalance() + " kr.&nbsp;&nbsp");
                            %>
                        </p>
                    </li>
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