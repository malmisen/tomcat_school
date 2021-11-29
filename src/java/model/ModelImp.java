/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import db.UserDAO;
import db.UserInterfaceDAO;
import recourses.User;

/**
 *
 * @author regularclip
 */
public class ModelImp implements ModelInterface{
    
    private UserInterfaceDAO userInterfaceDAO;
    
    public ModelImp(){
        userInterfaceDAO = new UserDAO();
    }
    
    @Override
    public boolean doesUserExist(User user) {
        User dbUser = userInterfaceDAO.getUser(user);
        if(dbUser.getUsername()==null) return false;
        return true;
    }

    @Override
    public boolean createNewUser(User user) {
        return userInterfaceDAO.createNewUser(user);
    }

    @Override
    public boolean loginUser(User user) {
        User u = userInterfaceDAO.getUser(user);
        if(u.equals(user)){
            return true;
        }
        return false;
    }
    
}


