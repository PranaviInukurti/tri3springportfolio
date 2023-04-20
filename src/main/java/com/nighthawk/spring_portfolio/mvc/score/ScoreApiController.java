package com.nighthawk.spring_portfolio.mvc.score;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.jwt.JwtTokenUtil;
import com.nighthawk.spring_portfolio.mvc.quiz.Quiz;
import com.nighthawk.spring_portfolio.mvc.quiz.QuizJpaRepository;

import java.util.*;

@RestController
@RequestMapping("/api/score")
public class ScoreApiController {
    //     @Autowired
    // private JwtTokenUtil jwtGen;
    /*
    #### RESTful API ####
    Resource: https://spring.io/guides/gs/rest-service/
    */

    // Autowired enables Control to connect POJO Object through JPA
    @Autowired
    private ScoreJpaRepository repository;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Autowired
    private QuizJpaRepository quizRepo;

    @GetMapping("/")
    public ResponseEntity<List<Score>> getScore() {
        return new ResponseEntity<>( repository.findAllByOrderByEmailAsc(), HttpStatus.OK);
    }

    @PostMapping("/postscore")
    public ResponseEntity<?> postScore(@RequestBody Submission submission, @CookieValue("jwt") String str) {
        String email = jwtUtil.getUsernameFromToken(str);
        int[] scoreAndTotal = checkAnswers(submission.getSub());
        if (scoreAndTotal == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Score scoreReturn = new Score(email, submission.getQuiz(), repository.findAllByEmail(email).size() + 1, scoreAndTotal[0], scoreAndTotal[1], submission);
        repository.save(scoreReturn);
        return new ResponseEntity<>(scoreReturn, HttpStatus.OK);
    }

    @GetMapping("/deletescore/{id}")
    public void deleteScore(@PathVariable long id) {
        Optional<Score> optional = repository.findById(id);
        if (optional.isPresent()) { // Good ID
            repository.deleteById(id); // value from findByID
        }

    }

    @PostMapping("/updatescore")
    public Score updateScore(@RequestBody Score score) {
        Optional<Score> score1 = repository.findById(score.getId()); 
        //SO THIS IS THE PIECE OF CODE TO CHANGE TYPES!!!!!!
        Score score2 = score1.orElse(null);

        //debugging
        //System.out.println("person2: " + person2); 
     
        
        //update user info only if info is provided
        //if (score.getQuiz() != null) {
            score2.setCorrect(score.getCorrect());
        //}

        
        return repository.save(score2); 
    }
    
    private int[] checkAnswers(Map<String,String> sub) {
        int[] scoreAndTotal = {0, 0};
        for (Map.Entry<String,String> entry: sub.entrySet()) {
            List<Quiz> oquiz = quizRepo.findByQuestionIgnoreCase(entry.getKey());
            if (oquiz.size() != 0) {
                Quiz quiz = oquiz.get(0);
                if (quiz.getAnswer().charAt(0) == entry.getValue().charAt(0)) {
                    scoreAndTotal[0]++;
                }
                scoreAndTotal[1]++;
            } else {
                return null;
            }
        }
        return scoreAndTotal;
    }
}
