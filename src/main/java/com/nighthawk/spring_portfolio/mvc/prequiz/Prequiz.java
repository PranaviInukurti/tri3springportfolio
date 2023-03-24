package com.nighthawk.spring_portfolio.mvc.prequiz;

public class Prequiz {
    public int scale;
    private int score;
    private int rating;
    private String level;

    public Prequiz (int scaleInput, int scoreInput, int ratingInput, String levelInput) {
        this.scale = scaleInput;
        this.score = scoreInput;
        this.rating = ratingInput;
        this.level = levelInput;
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

    /*
    public String helpStudents (String level) {
        if (level == "Begineer") {
            
        }
        else if (level == "Intermediate") {

        }
        else if (level == "Advanced") {

        }
        else {
            return null; //place holder
        }
    }
    */
}

