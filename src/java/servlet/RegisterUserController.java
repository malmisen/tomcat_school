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


/**
 *
 * @author regularclip
 */
public class RegisterUserController extends HttpServlet {
    

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //fetch inserted values
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        //check if user already exists
        UserDAO dao = new UserDAO();
        User dbUser = dao.getUser(user);
        if(dbUser.getUsername() == null){
            //if user does not exist then go ahead and create new one
            dao.createNewUser(user);
        }
        
        
        /*
        //CHECK IF USER ALREADY EXISTS
        model = new ModelImp();
        boolean userAlreadyExists = model.doesUserExist(user);
        
        //IF USER DOES NOT EXIST CREATE NEW USER
        boolean created = false;
        if(!userAlreadyExists){
            created = model.createNewUser(user);
        }        
        System.out.println("CREATED NEW USER: " + created);*/
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
