/* 
package com.nighthawk.spring_portfolio.mvc.prequiz;

import java.util.Scanner;

public class Prequiz {
    private int scale;
    private int score;
    private int rating;
    private String level;
    private Long id;

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

*/