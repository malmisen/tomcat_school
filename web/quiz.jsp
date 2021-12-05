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
        %>
        
        <form method="get" action="QuizController">
            <% for(Quiz q: quizzes.getAllQuizzes()){ %>
            <% String conc = q.getId() + "#" + user.getId(); %>
            <button type="submit" name="<%=q.getSubject()%>" value="<%=conc%>"><%=q.getSubject()%> </button>
            <%}%>
        </form>
                 
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
