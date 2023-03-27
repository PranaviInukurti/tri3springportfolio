package com.nighthawk.spring_portfolio.mvc.prequiz;

import java.util.Scanner;
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

/*
Person is a POJO, Plain Old Java Object.
First set of annotations add functionality to POJO
--- @Setter @Getter @ToString @NoArgsConstructor @RequiredArgsConstructor
The last annotation connect to database
--- @Entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TypeDef(name="json", typeClass = JsonType.class)
public class Prequiz {
     // automatic unique identifier for Person record
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int scale;
    private int score;
    private int rating;
    private String level;

    public Prequiz (int scaleInput, int scoreInput, int ratingInput, String levelInput, Long id) {
        this.scale = scaleInput;
        this.score = scoreInput;
        this.rating = ratingInput;
        this.level = levelInput;
        this.id = id;
    }

    //if statements to compare score and rating/level


    public String computeRatingPrequiz() {
        double average  = (score + rating)/2;

        if (average <= 3) 
        {
            level = "Beginner";
            return level;
        }
        else if (average >= 4 && average <= 8)
        {
            level = "Intermediate";
            return level;
        }
        else if (average == 9 || average == 10) 
        {
            level = "Advanced";
            return level;
        }
        else 
        {
            return null;
            //use HTTPS.StatusOK function later, place holder 
        
        }
    }

      // Tester method
      public static void main(String[] args) {
        // Random set of test cases
        Prequiz quiz = new Prequiz(10, 5, 7, "test", (long) 5);
        System.out.println("Decrypted Text: " + quiz.computeRatingPrequiz());
    }


}

