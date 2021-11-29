/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recourses;

/**
 *
 * @author regularclip
 */
public class UserResult {
    private String subject;
    private int score;
    
    public UserResult(){
        
    }
    
    public String getQuiz(){
        return subject;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setQuiz(String quiz){
        this.subject = quiz;
    }
    
    public void setScore(int score){
        this.score = score;
    }
}
