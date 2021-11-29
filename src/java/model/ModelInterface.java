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
    boolean doesUserExist(String username); 
    boolean createNewUser(String username, String password);
    boolean loginUser(String username, String password);
}
