<%-- 
    Document   : userinfo
    Created on : 11-03-2019, 19:10:31
    Author     : sofieamalielandt
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>

<form method = "POST">
    <center id="shop"> 
        <div>   
            <%                
                out.println("<b>Username</b> <input type =\"text\" id=\"username\" name =\"username\" value=\"" + user.getUserName() + "\" minlength=\"4\" required disabled>");
                out.println("<br><br><b>Email</b> <input id=\"email\" type =\"text\" name =\"email\" value=\"" + user.getEmail() + "\" disabled>");
            %>
            <br><br><br><br>

            <%
                out.println("<b>Old Password</b> <input id=\"oldpassword\" onclick=\"opassword()\" type =\"password\" name =\"oldpassword\" value=\"" + user.getPassword() + "\" minlength=\"4\" required disabled>");
                out.println("<b>New Password</b> <input id=\"newpassword\" onclick=\"password()\" type =\"password\" name =\"newpassword\" value=\"" + user.getPassword() + "\" minlength=\"4\" required disabled>");

                String update = (String) session.getAttribute("update");
                if (update != null)
                {
                    out.println("<br><br><br>" + update);
                    session.removeAttribute("update");
                }
            %>
            <br><br><br>
            <button id="disable" type="submit" formaction="CommandController?command=update" disabled>save</button>
            <button id="enable" onclick="enableBtn()">update</button>
            <script>
                function disableBtn() {
                    document.getElementById("enable").disabled = false;
                    document.getElementById("disable").disabled = true;
                    document.getElementById("username").disabled = true;
                    document.getElementById("email").disabled = true;
                    document.getElementById("oldpassword").disabled = true;
                    document.getElementById("newpassword").disabled = true;
                }

                function enableBtn() {
                    document.getElementById("username").disabled = false;
                    document.getElementById("email").disabled = false;
                    document.getElementById("oldpassword").disabled = false;
                    document.getElementById("newpassword").disabled = false;
                    document.getElementById("disable").disabled = false;
                    document.getElementById("enable").disabled = true;
                }

                function password() {
                    document.getElementById("newpassword").value = '';
                    document.getElementById("oldpassword").value = '';
                }

                function opassword() {
                    document.getElementById("oldpassword").value = '';
                }


            </script>
        </div> 
    </center>

</form>   
</body>
</html>
