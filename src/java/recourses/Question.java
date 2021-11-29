/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recourses;

/**
 *
 * @author regularclip
 */
public class Question {
    private int id;
    private String question;
    private String options;
    private String answer;
    
    public Question(){
        
    }
    
    public void setId(int id){
        this.id = id;
    }
    public void setQuestion(String question){
        this.question = question;
    }
    public void setOptions(String options){
        this.options = options;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public int getId(){
        return id;
    }
    public String getQuestion(){
        return question;
    }
    public String getOptions(){
        return options;
    }
    public String getAnswer(){
        return answer;
    }
}
