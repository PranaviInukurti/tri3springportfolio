package com.nighthawk.spring_portfolio.mvc.score;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.text.SimpleDateFormat;

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

   
    @GetMapping("/")
    public ResponseEntity<List<Score>> getScore() {
        return new ResponseEntity<>( repository.findAllByOrderByEmailAsc(), HttpStatus.OK);
    }

    @PostMapping("/postscore")
    public Score postScore(@RequestBody Score score) {
        Score scoreReturn = new Score(score.getId(), score.getEmail(), score.getQuiz());
        //return scoreReturn; 
        return repository.save(scoreReturn);
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
            score2.setQuiz(score.getQuiz());
        //}

        
        return repository.save(score2); 
    }
    


  
}
