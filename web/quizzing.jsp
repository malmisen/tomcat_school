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
         <% User currentUser = (User)application.getAttribute("user"); %>
        <h2>Good luck!</h2>
        <form method = "post" action = "QuizController" name="userId" value="<%=currentUser.getId()%>" >            
                <% Questions questionss = (Questions)application.getAttribute("questions"); int i = 0; %>
             
                <%  %>
                     <% for(Question que: questionss.getListOfQuestions()){ %> 
                     <% String[] options = que.getOptions().split("/"); %>
                            <h3> <%=que.getQuestion()%> </h3>
                            <% for(String o: options) { %>
                            <% System.out.println("options: " + o.toString());%>
                            <input type="checkbox" name="<%=i++%>" value="<%=o.toString()%>">
                            <label for="<%=o.toString()%>"><%=o.toString()%></label><br>
                            <% } %>
                        <%}%>     
            <br>
            <button type="submit" name="play" value="<%=currentUser.getId()%>">
                Submit!
                </button>
        </form>
    </body>
</html>
