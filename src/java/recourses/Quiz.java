/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recourses;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author regularclip
 */
public class Quiz implements Serializable{
    
    private int id;
    private String subject;
    private ArrayList<Question> questions;
    
    public Quiz(){
        questions = new ArrayList<Question>();
    }
    
    private void setId(int id){
        this.id = id;
    }
    private void setSubject(String subject){
        this.subject = subject;
    }
    private void addQuestion(Question q){
        questions.add(q);
    }
    
    
    
}
