package servlet;

import db.QuizDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import resources.Questions;
import resources.Quizzes;

public class QuizController extends HttpServlet {
   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = request.getRequestDispatcher("quizzes.jsp");
        
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Questions questions = new Questions();
        QuizDAO quizDAO = new QuizDAO();
        Quizzes quizzes = quizDAO.getQuizzes();
        
        for(int i = 0; i < quizzes.getSize(); i++){
            questions = quizDAO.getQuestions(quizzes.getQuiz(i).getId());
            System.out.println("Quiz subject: " + quizzes.getQuiz(i).getSubject() + " id: " + quizzes.getQuiz(i).getId());
                
            for(int j = 0; j < questions.getSize(); j++){
                ServletContext application = request.getServletContext();
                application.setAttribute("questions", questions);
                System.out.println("Question: " + questions.getQuestion(j).getQuestion());
                System.out.println("Options: "  + questions.getQuestion(j).getOptions());
                System.out.println("Answer: "   + questions.getQuestion(j).getAnswer());
                }
            }
        
        int count = 0;
        String a = "", b = "", c = "";
        a = request.getParameter("first question");
        b = request.getParameter("second question");
        c = request.getParameter("third question");
        System.out.println("This is what you are looking for: " + a + b + c);
//        if(a.equals("first")){count++; System.out.println("Correct");}
//        else{System.out.println("Incorrect");}
//        if(count==3){System.out.println("Congratulations, you have answered all questions correctly.");}
//        else{System.out.println("You have answered " + count + " questions correctly.");}
        
        ServletContext application = request.getServletContext();
        application.setAttribute("quizzes", quizzes);
        
        RequestDispatcher rd = request.getRequestDispatcher("quizzing.jsp");
                
        rd.forward(request, response);
    }
}
