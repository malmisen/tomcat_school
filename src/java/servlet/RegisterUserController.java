/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ModelImp;
import recourses.User;


/**
 *
 * @author regularclip
 */
public class RegisterUserController extends HttpServlet {
    
    private ModelImp model;

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
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println("Email: " + email +"\n"+"Username: " + username +"\n"+"Password: " + password);
        model = new ModelImp();
        boolean userAlreadyExists = model.doesUserExist(username);
        System.out.println("Username is taken: " + userAlreadyExists);
        boolean created = false;
        if(!userAlreadyExists){
            created = model.createNewUser(username, password);
        }        
        System.out.println("CREATED NEW USER: " + created);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
