package com.nighthawk.spring_portfolio.mvc.prequiz;

public class Prequiz {
    private int scale;
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

    double average  = (score + rating)/2;

    if (average <= 3) {
        System.out.println("You are a beginner. You will be assigned the beginner questions on Binary Search and Sorting until proven competency");
        level = "Beginner";
    }
    else if (average >= 4 && average <= 8)
    {
        System.out.println("You are in the intermediate level. You will be assigned the intermediate questions on Binary Search and Sorting until proven competency");
        level = "Intermediate";
    }
    else if (average = 9 || average = 10) 
    {
        System.out.println("You are in the advanced range. You will be given the advanced questions on Binary Search and Sorting until proven competency");
        level = "Advanced";
    }

}
