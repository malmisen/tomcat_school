/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import recourses.User;

/**
 *
 * @author regularclip
 */
public interface ModelInterface {
    boolean doesUserExist(User user); 
    boolean createNewUser(User user);
    boolean loginUser(User user);
}
