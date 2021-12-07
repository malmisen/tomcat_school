package servlet;

import db.QuizDAO;
import db.UserDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Question;
import beans.Questions;
import beans.Quiz;
import beans.Quizzes;
import beans.User;
import beans.UserResult;
import beans.UserResults;

public class QuizController extends HttpServlet {
    
    private User user;
    private Quiz toBePlayed;
   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html;charset=UTF-8");
        
        /* Structures */
        ServletContext application = request.getServletContext();
        Questions questions = new Questions();
        QuizDAO quizDAO = new QuizDAO();
        Quizzes quizzes = quizDAO.getQuizzes();
        user = new User();
        
        for(Quiz quiz: quizzes.getAllQuizzes()){
            String req = request.getParameter(quiz.getSubject());
            if(req != null){
                System.out.println("-----------------REQ WAS NOT NULL-------------------");
                String[] conc = req.split("#");
                int userId = Integer.parseInt(conc[1]);
                toBePlayed = quiz;
                System.out.println("USER ID: " + userId);
                user.setId(userId);
                break;
            }
        }
        /* provide quizzes/questions to view */
        for(int i = 0; i < quizzes.getSize(); i++){
            questions = quizDAO.getQuestions(quizzes.getQuiz(i).getId());
            System.out.println("Quiz subject: " + quizzes.getQuiz(i).getSubject() + " id: " + quizzes.getQuiz(i).getId());
                
            for(int j = 0; j < questions.getSize(); j++){
                application.setAttribute("questions", questions);
                System.out.println("Question: " + questions.getQuestion(j).getQuestion());
                System.out.println("Options: "  + questions.getQuestion(j).getOptions());
                System.out.println("Answer: "   + questions.getQuestion(j).getAnswer());
                }
            }
        
        application.setAttribute("user", user);
        application.setAttribute("questions", questions);
        application.setAttribute("quizzes", quizzes);
        RequestDispatcher rd = request.getRequestDispatcher("quizzing.jsp");        
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        /* Application */
        ServletContext application = request.getServletContext();
      
        /* DAO */
        QuizDAO quizDAO = new QuizDAO();
        UserDAO dao = new UserDAO();
        
        /* Structures */
        Questions questions = new Questions();
        Quizzes quizzes = quizDAO.getQuizzes();
        UserResult userResult = new UserResult();
        ArrayList<String> correctAnswers = new ArrayList<String>();
        
        int totalPoints = 0;
        //int quizId = 0;
        
        /* Hard coded, should probably be an array list (assuming there are only 3 questions) */
        boolean[] correct = {true, true, true};
        
        /* get questions */
        for(int i = 0; i < quizzes.getSize(); i++){
            questions = quizDAO.getQuestions(quizzes.getQuiz(i).getId());
            System.out.println("Quiz subject: " + quizzes.getQuiz(i).getSubject() + " id: " + quizzes.getQuiz(i).getId());
                
            for(int j = 0; j < questions.getSize(); j++){
                application.setAttribute("questions", questions);
                System.out.println("Question: " + questions.getQuestion(j).getQuestion());
                System.out.println("Options: "  + questions.getQuestion(j).getOptions());
                System.out.println("Answer: "   + questions.getQuestion(j).getAnswer());
                }
            }
        /*
        for(Quiz q: quizzes.getAllQuizzes()){
            
        }*/
        /* Set up correct answers */
        for(Question q: questions.getListOfQuestions()){
         
            String[] qAnswers = q.getAnswer().split("/");
            for(int i = 0; i < qAnswers.length; i++){
                correctAnswers.add(qAnswers[i]);
            }
        }
        
        /* fetch client answers  */
        ArrayList<String> answers = new ArrayList<String>();
        int i = 0;
        int k = 0;
        int questionCounter = 0;
        for(Question q: questions.getListOfQuestions()){
            
            /*  Client answers first 3 */
            for(String a: q.getOptions().split("/")){
                String answer = request.getParameter(String.valueOf(i));
                if(answer != null) answers.add("1");
                else               answers.add("0");
                
                System.out.println("Answer: " + answers.get(k));
                i++;
                k++;
            }
            
            /* Correct answers first three*/
            String[] c = q.getAnswer().split("/");
            
            /*  Check points */
            for(int j = 0; j < answers.size(); j++){
                if(!c[j].equals(answers.get(j))){
                    correct[questionCounter] = false;
                }
            }
            
            /* reset  */
            answers = new ArrayList<String>();
            questionCounter++;
            k = 0;
            
        }

        /* Count total points */
        for(boolean val: correct){
            if(val == true){
                totalPoints++;
            }
        }
        
      

        System.out.println("USER: " + user.getId());
        userResult.setQuizId(toBePlayed.getId());
        userResult.setScore(totalPoints);
        
        System.out.println("Total points: " + totalPoints);
        
        /* get user */
        User userDB = dao.getUserById(user.getId());
        System.out.println("username: " + userDB.getUsername());
        /* update user results*/
        dao.updateUserResults(user, userResult);
        UserResults results = dao.getUserResults(userDB);
        System.out.println("RESULTS " + results.getResult(0).getScore());
        
        application.setAttribute("results", dao.getUserResults(userDB));
        application.setAttribute("user", userDB);
        application.setAttribute("quizzes", quizzes);
        RequestDispatcher rd = request.getRequestDispatcher("quiz.jsp");        
        rd.forward(request, response);
    }
}
