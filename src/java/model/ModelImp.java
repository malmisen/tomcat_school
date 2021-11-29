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
    public boolean doesUserExist(String username) {
        User user = userInterfaceDAO.getUserByUsername(username, null);
        if(user.getUsername()==null) return false;
        return true;
    }

    @Override
    public boolean createNewUser(String username, String password) {
        return userInterfaceDAO.createNewUser(username, password);
    }

    @Override
    public boolean loginUser(String username, String password) {
        User user = userInterfaceDAO.getUserByUsername(username, password);
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
    
}


