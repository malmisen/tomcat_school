/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recourses;

import java.util.ArrayList;

/**
 *
 * @author regularclip
 */
public class Quizzes {
    private ArrayList<Quiz> quizzes;
    
    public Quizzes(){
        quizzes = new ArrayList<Quiz>();
    }
    
    public void addQuizzes(Quiz q){
        quizzes.add(q);
    }
    
}
