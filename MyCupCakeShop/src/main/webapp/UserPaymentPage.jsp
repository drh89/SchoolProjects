<%-- 
    Document   : UserPaymentPage
    Created on : 06-03-2019, 00:04:06
    Author     : Dennis
--%>

<%@page import="logic.User"%>
<%@page import="logic.CupcakeMapperFacade"%>
<%@page import="logic.Bottom"%>
<%@page import="logic.Topping"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.OrderLine"%>
<%@page import="logic.OrderLine"%>
<%@page import="logic.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .topright{
                position:absolute;
                top: 8px;
                right: 25px;
                font-size: 14px;

            }
            .topright2{
                position:absolute;
                top: 155px;
                right: 15px;
                font-size: 14px;

            }
            .midtleft{
                position: absolute;
                top: 10%;
                left: 15%;

            }
            .left{
                postion: absolute;
                top: 15%;


            }
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: palevioletred;
            }
            tr:nth-child(odd) {
                background-color: darkviolet;
            }

        </style>
    </head>
    <body bgcolor="darkviolet">
    <center><i><h1>Checkout:</h1></i></center>
                <% ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
                    ArrayList<OrderLine> orderLines = (ArrayList<OrderLine>) cart.getOrderlines();
                    User user = (User) session.getAttribute("user");
                %>
    <div class = "topright">


        <%out.print("Hej" + "\n");%>
        <i> <%out.print(user.getUsername());%></i>
        <br> <b>Wallet:</b> <%out.print(user.getBalance());%> Kr</br>


        <form method="POST">
            
            <br><input type="submit" name = "valg" value="Buy cupcakes" formaction="ShopServlet"> 
            <br>
            <br><input type="submit" name = "valg" value="Remove orderline" formaction="ShopServlet"> 
            <br>
            <br><input type="submit" name = "valg" value="Add funds" formaction="ShopServlet"> 

        

    </div>
    <div class="midtleft">

        <%  CupcakeMapperFacade cmf = new CupcakeMapperFacade();
            Bottom tempB;
            Topping tempT;
            double totalprice = 0;
//            int placeSetter = 0;
        %>
        <center><table>
                <tr>
                    <th>Cupcake</th>
                    <th>Amount</th>
                    <th>Price</th>                       
                </tr>
                <% for (OrderLine orderLine : orderLines) { %>

                <% tempB = cmf.getBottom(orderLine.getBottomId());
                    tempT = cmf.getTopping(orderLine.getToppingId());
                    totalprice += (orderLine.getPrice() * orderLine.getAmount());

                %>
                <tr>
                    <td><%out.print(tempB.getFlavour() + "/" + tempT.getFlavour());%></td>
                    <td><center><%out.print(orderLine.getAmount());%></center></td>
                <td><%out.print((orderLine.getPrice() * orderLine.getAmount()) + " kr");%><input type="radio" name="lineId" id="lineId" value ="<%out.print(orderLine.getId());%>"</td>
                </tr>




                <%}%>
                <tr>
                    <td><%out.print("");%></td>
                    <td><%out.print("Total price: ");%></td>
                    <td><%out.print(totalprice + " kr");%></td> 
                <input type ="hidden" name ="totalprice" value="<%out.print(totalprice);%>">


                </tr>
            </table></center>
                </form>
    </div>
    
    <form method="GET">
        <div class="topright2">
            <br><input type="submit" value="Add more cupcakes" formaction="LoginServlet">
            <input type ="hidden" name ="password" value="<%out.print(user.getPassword());%>">
           
            <input type ="hidden" name ="email" value="<%out.print(user.getEmail());%>">
    </div>    
    </form>
    
</body>
</html>
