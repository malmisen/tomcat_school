/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package db;

import resources.User;

/**
 *
 * @author regularclip
 */
public interface UserInterfaceDAO {
    User getUser(User user);
    boolean createNewUser(User user);
}
