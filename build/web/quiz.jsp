<%-- 
    Document   : quiz
    Created on : 28 Nov 2021, 17:59:52
    Author     : regularclip
--%>

<%@page import="recourses.UserResult"%>
<%@page import="recourses.UserResults"%>
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
        <h1>Account info!</h1>
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
        <h1>Prior Results</h1>
        <table><tr><th>Category</th><th>Score</th></tr>
        <%
            // pre defined variables are request, response, out, session, application
            UserResults results = (UserResults)application.getAttribute("results");
            for(UserResult r : results.getResults()){
        %>
    <tr>
        <td><%= r.getQuiz() %></td>
        <td><%= r.getScore() %></td>
    </tr>

        <%
            }
        %>
        </table>
    </body>
</html>
