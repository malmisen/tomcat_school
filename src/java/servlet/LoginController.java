/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import db.UserDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import recourses.User;
import recourses.UserResults;

/**
 *
 * @author regularclip
 */
public class LoginController extends HttpServlet {
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
         System.out.println("SET Username: " + username);
         System.out.println("SET PAssword: " + password);
     
        
        UserDAO dao = new UserDAO();
        User dbUser = dao.getUser(user);
         System.out.println("DBUser name: " + dbUser.getUsername());
         System.out.println("DBUser pass: " + dbUser.getPassword());
         System.out.println("DBUser id: " + dbUser.getId());
        if(dbUser.equals(user)){
            
            UserResults results = dao.getUserResults(dbUser);
           
            for(int i = 0; i < results.getSize(); i++){
                System.out.println("Subject: " + results.getResult(i).getQuiz()  + " Score:" + results.getResult(i).getScore());
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("quiz.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        }
        
        /*
        model = new ModelImp();
        boolean success = model.loginUser(user);
        System.out.println("LOGIN WAS A SUCCESS: " + success); 
        if(success){
            RequestDispatcher rd = request.getRequestDispatcher("quiz.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        }*/
    }
    
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
