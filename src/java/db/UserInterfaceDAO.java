/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package db;

import recourses.User;

/**
 *
 * @author regularclip
 */
public interface UserInterfaceDAO {
    User getUserByUsername(String username, String password);
    boolean createNewUser(String username, String password);
}
