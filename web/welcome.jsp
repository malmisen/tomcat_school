<%-- 
    Document   : welcome.jsp
    Created on : 22 Nov 2021, 17:11:12
    Author     : regularclip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="LoginController">
            Username <input type="text" name="username"><br>
            Password <input type="text" name="password"><br>
            <input type="hidden" name="action" value="login">
            <input type="submit" value="Login">  
        </form>
        <form method="get" action="RegisterUserController">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register">
        </form>
    </body>
</html>