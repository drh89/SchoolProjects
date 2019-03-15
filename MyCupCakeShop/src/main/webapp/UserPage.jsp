<%@page import="logic.CupcakeMapperFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="logic.OrderLine"%>
<%@page import="logic.User"%>
<%@page import="logic.Topping"%>
<%@page import="logic.Bottom"%>
<%@page import="java.util.List"%>
<%@page import="data.CupcakeMapper"%>
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
            .midtleft{
                position: absolute;
                top: 42%;
                left: 15%;

            }
            .top{
                postion: absolute;
                top: 50%;


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
      
       
      

            <%
                User user = (User) session.getAttribute("user");
                if (user.getUserId() == 0) {
                    request.getRequestDispatcher("index.html");
                }
                CupcakeMapperFacade cmf = new CupcakeMapperFacade();
                    List<Bottom> bottoms = cmf.getAllBottoms();
                    List<Topping> toppings = cmf.getAllToppings();
            %>
            <div class = "topright">


                <%out.print("Hej" + "\n");%>
                <i> <%out.print(user.getUsername());%></i>
                <br> <b>Wallet:</b> <%out.print(user.getBalance());%> Kr</br>
                
                <form method="POST">
                <br><input type="submit" name = "valg" value="Checkout" formaction="ShopServlet"> </br>
                <br><input type="submit" name = "valg" value="Logout" formaction="ShopServlet"> </br>
                </form>
                
            </div>
                  <form method ="POST" >
                
                
                      <div class ="left" > 
                <table>
                <tr><th>Toppings</th>
                    <th>Bottoms</th></tr>
                <%
                for (Topping topping : toppings) {%>
                <tr>        
                <td> <%out.print(topping);%><input type="radio" name="topping" id ="toppingId" value = "<%out.print(topping.getId());%>"</td>
                <td><%if(bottoms.size() >= topping.getId()){
                    out.print(bottoms.get(topping.getId()-1));%><input type="radio" name="bottom" id = "bottomId" value = "<%out.print(bottoms.get(topping.getId()-1).getId());%>"</td>
                
                            <%}%></td>
                </tr>
                <% }%>


                </table>
            </div>
                <div class =".top"><!--
            
                    -->               <center> <br><b>Amount</b></br>        
                <br> <input type ="text" name ="amount" id="amount" value="1"> </br>
                <br><input type="submit" name ="valg" value="Add to cart" formaction="ShopServlet" </br>
                    </center>
            </div>
            
        </form>

    </body>
</html>
