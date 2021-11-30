<%-- 
    Document   : quiz
    Created on : 28 Nov 2021, 17:59:52
    Author     : regularclip
--%>

<%@page import="recourses.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlet.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       <table><tr><th>Username</th><th>Password</th></tr>
        <%
            // pre defined variables are request, response, out, session, application
            User user = (User)application.getAttribute("user");

        %>
    <tr>
        <td><%= user.getUsername() %></td>
        <td><%= user.getPassword() %></td>
    </tr>

        <%
            
        %>
        </table>
    </body>
</html>
