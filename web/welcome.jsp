<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style> body {font-family: Helvetica, sans-serif;} </style>
        <title>Welcome to another quiz game</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <table>
            <tr>
        <h1>Welcome to another quiz game</h1>
        </tr>
        <tr>
        <h2>Please login or register</h2>
        </tr>
        <tr>
        <form method="post" action="LoginController">
            Username <input type="text" name="username"><br>
            Password <input type="text" name="password"><br>
            <input type="hidden" name="action" value="login">
            <input type="submit" value="Login">  
        </form>
        </tr>
        <tr>
        <form method="get" action="RegisterUserController">
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register">
        </form>
        </tr>
    </body>
</html>