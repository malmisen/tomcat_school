/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import recourses.User;

/**
 *
 * @author regularclip
 */
public class UserDAO implements UserInterfaceDAO {
    
    private static final String USER_TABLE_NAME = "users";
    
    private static final String USER_COLUMN_USERNAME_NAME = "username";
    private static final String USER_COLUMN_PASSWORD_NAME = "password";
    
    private DBHandler db;
    private PreparedStatement createNewUserStatement;
    private PreparedStatement searchExistingUserStatement;
    
    public UserDAO(){
        try{
            db = DBHandler.getInstance();
            prepareStatements();
        }catch(SQLException e){
            System.out.println("Something went wrong when preparing statement!");
            e.printStackTrace();
        }
    }
    
    @Override
    public User getUser(User user) {
        ResultSet result = null;
        User dbUser = new User();
        try{
            searchExistingUserStatement.setString(1, user.getUsername());
            System.out.println("Executing query..");
            result = searchExistingUserStatement.executeQuery();
            System.out.println("RESULT: " + result.toString());
            while(result.next()){
                dbUser.setUsername(result.getString(USER_COLUMN_USERNAME_NAME));
                dbUser.setPassword(result.getString(USER_COLUMN_PASSWORD_NAME));
            }
        }catch(SQLException e){
            System.out.println("Something went wrong when executing query");
            e.getStackTrace();
        }
        return dbUser;
    }

   
    @Override
    public boolean createNewUser(User user) {
       
        int updatedRows = 0;//keep count of the number of updated rows
        try{
            createNewUserStatement.setString(1, user.getUsername());
            createNewUserStatement.setString(2, user.getPassword());
            updatedRows = createNewUserStatement.executeUpdate();
            if(updatedRows != 1){
                System.out.println("COULD NOT UPDATE ROW");
            }
        }catch(SQLException e){
            System.out.println("Woops, something went wrong when creating new user in DB");
            e.getStackTrace();
        }
        return updatedRows == 1;
        
    }
    
    private void prepareStatements() throws SQLException{
        searchExistingUserStatement = db.getCon().prepareStatement("SELECT username, password FROM users WHERE username = ?");
        createNewUserStatement = db.getCon().prepareStatement("INSERT INTO users (username,password) VALUES (?,?)");
    }    

   
    
}
