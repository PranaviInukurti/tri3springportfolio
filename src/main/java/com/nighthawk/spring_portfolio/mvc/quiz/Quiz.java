 
package com.nighthawk.spring_portfolio.mvc.quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import static javax.persistence.FetchType.EAGER;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.format.annotation.DateTimeFormat;

import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TypeDef(name="json", typeClass = JsonType.class)
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question;
    private String answer;
    //private int questionsRight;
    //private int questionstWrong;
    //private String right;
    //private String wrong;
    private String difficulty;
    private String topic; 

        // Initialize static test data 
    public static Quiz[] init() {

        // basics of class construction
        // Quiz q1 = new Quiz();
        // q1.setQuestion("Which of the following is a correct way to create an ArrayList? || A. ArrayList<int> myList = new ArrayList<int>(); || B. ArrayList<String> myList = ArrayList<String>(); || C. ArrayList<> myList = new ArrayList<Integer>(); || D. ArrayList<Integer> myList = new ArrayList<Integer>();");
        // q1.setAnswer("D");
        // q1.setDifficulty("easy");
        // q1.setTopic("arraylist");

        ArrayList<Quiz> quizArrayList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("quizQuestions.txt"));
            String line;
            int i = 1;
            Quiz q = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (i % 4 == 1) {
                    q = new Quiz();
                    q.setQuestion(line);
                }
                if (i % 4 == 2) {
                    q.setAnswer(line);
                }
                if (i % 4 == 3) {
                    q.setDifficulty(line);
                }
                if (i % 4 == 0) {
                    q.setTopic(line);
                    quizArrayList.add(q);
                    i = 0; 
                }
                i++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(quizArrayList);

        Quiz[] quizs = new Quiz[quizArrayList.size()];
        for (int i = 0; i < quizArrayList.size(); i++) {
            quizs[i] = quizArrayList.get(i);
        }

        return(quizs);
    }

    public static void main(String[] args) {
        // obtain Person from initializer
        Quiz quizs[] = init();

        // iterate using "enhanced for loop"
        for( Quiz quiz : quizs) {
            System.out.println(quiz);  // print object
        }
    }
  
// Temporarily commented out, otherwise Main.java fails
/* 
    public String analysis (String questions, String answers) {

        if (answers == 1) {

        }
        else if (answers == 0) {

        }
        else {
        
        }

    }

     public static void main(String[] args) {

     }
    */
}
