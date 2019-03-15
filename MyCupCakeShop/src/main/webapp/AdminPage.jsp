<%-- 
    Document   : AdminPage
    Created on : 01-03-2019, 21:15:19
    Author     : Dennis
--%>


<%@page import="logic.OrderLine"%>
<%@page import="java.util.List"%>
<%@page import="logic.OrderMapperFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>

            scd {
                overflow: auto;
            }
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 40%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
                color: white;
            }

            tr:nth-child(even) {
                background-color: blue;
                color: white;
            }
            tr:nth-child(odd) {
                background-color: darkblue;
                color: white;
            }
            back-admin{
                background-color: black;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="black" >
    <center><i><h1 style ="color: white">Orders and Income</h1></i></center>
                <%
                    OrderMapperFacade omf = new OrderMapperFacade();
                    List<OrderLine> orders = omf.getAllOrderLines();

                    double totalIncome = 0;
                %>

    <div >
        <center><table>
                <tr>
                    <th>Cupcake</th>
                    <th>Amount</th>
                    <th>Order Id</th>
                    <th>User Id</th>
                    <th>Price</th>
                    <th>Date of Order</th>
                </tr>
                <%for (OrderLine orderLine : orders) {%>

                <tr>
                    <td><%out.print(orderLine.getBottomName() + "/" + orderLine.getToppingName());%></td>
                    <td><%out.print(orderLine.getAmount());%></td>
                    <td><%out.print(orderLine.getOrderId());%></td>
                    <td><%out.print(orderLine.getUserId());%></td>
                    <td><%out.print(orderLine.getPrice() + " kr");%></td>
                    <td><%out.print(orderLine.getOrderDate().toString());%></td>
                    <%totalIncome += orderLine.getPrice();
                    }%>


                </tr>
                <tr>
                    <td><%out.print("Income:");%></td>
                    <td><%out.print("");%></td>
                    <td><%out.print("");%></td>
                    <td><%out.print("");%></td>
                    <td><%out.print("");%></td>
                       <td><%out.print(totalIncome + " kr");%></td>
                    
                </tr>

            </table>  </center>                                  
    </div>        









</body>
</html>
