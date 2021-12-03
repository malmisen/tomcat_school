<%@page import="resources.*"%>
<%@page import="servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style> body {font-family: Helvetica, sans-serif;} </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Another quiz game</title>
    </head>
    <body>
        <%
            // pre defined variables are request, response, out, session, application
            User user = (User)application.getAttribute("user");   
        %>
        
        <h1>Welcome <%= user.getUsername() %></h1>
        <p>Which quiz would you like to play?</p>
        <%
            Quizzes quizzes = (Quizzes)application.getAttribute("quizzes");
            for(int i = 0; i < quizzes.getSize(); i++){
        %>
        <table>
        <tr>
            <td>
                <form method="post" action="QuizController">
                <button type="submit">
                <%= quizzes.getQuiz(0).getSubject() %>
                </button>
                </form>
            </td>
            <td>
                <button type="submit">
                Clickbait
                </button>
            </td>    
            <td>    
                <button type="submit">
                A cool quiz
                </button>
            </td>
        </tr>
        </table>
        <%
            }
        %>            
        <h1>Prior results</h1>
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
