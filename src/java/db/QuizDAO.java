/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import recourses.User;
import recourses.UserResult;
import recourses.UserResults;

/**
 *
 * @author regularclip
 */
public class QuizDAO {
    
    private DBHandler db;
    private PreparedStatement getQuizzes;
   
    
    public QuizDAO(){
        try{
            db = DBHandler.getInstance();
            prepareStatements();
        }catch(SQLException e){
            System.out.println("Something went wrong when preparing statement!");
            e.printStackTrace();
        }
    }
    

  
    
    private void prepareStatements() throws SQLException{
        
    }    
}
