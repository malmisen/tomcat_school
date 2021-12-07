package servlet;

import db.UserDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.User;

public class RegisterUserController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response); 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }
}
