<%@page import="java.util.ArrayList"%>
<%@page import="resources.*"%>
<%@page import="servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
    </head>
    <body>
        <%
            Quizzes quizzes = (Quizzes)application.getAttribute("quizzes");
            String[] q = new String[3];
            String[] answers = new String[3];
        %>    
        <h1><%= quizzes.getQuiz(0).getSubject() %></h1>
        <% 
           Questions questions = (Questions)application.getAttribute("questions");

           for(int i = 0; i < quizzes.getSize(); i++) {
           for(int j = 0; j < questions.getSize(); j++) {
           
           q[j]=(questions.getQuestion(j).getQuestion());
           String x = questions.getQuestion(j).getOptions();
           answers = x.split("/");
           }}
        %>
        
        <form method="post" action="QuizController">        
        <label><%= q[0] %></label><br>
        <input type="radio" name="first question" value="first"><%= answers[0] %><br>
        <input type="radio" name="first question" value="second"><%= answers[1] %><br>
        <input type="radio" name="first question" value="third"><%= answers[2] %><br>
        <br><br>
        
        <label><%= q[1] %></label><br>
        <input type="radio" name="second question" value="first"><%= answers[0] %><br>
        <input type="radio" name="second question" value="second"><%= answers[1] %><br>
        <input type="radio" name="second question" value="third"><%= answers[2] %><br>
        <br><br>
        
        <label><%= q[2] %></label><br>
        <input type="radio" name="third question" value="first"><%= answers[0] %><br>
        <input type="radio" name="third question" value="second"><%= answers[1] %><br>
        <input type="radio" name="third question" value="third"><%= answers[2] %><br>
        <br><br>
        
        <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
