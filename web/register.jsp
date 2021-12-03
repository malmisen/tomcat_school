<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style> body {font-family: Helvetica, sans-serif;} </style>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Register</h1>
        <form method="post" action="RegisterUserController">
            Username <input type="text" name="username"><br>
            Password <input type="text" name="password"><br>
            <input type="hidden" name="action" value="register">
            <input type="submit" value="Register">  
        </form>
    </body>
</html>
