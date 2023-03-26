package com.nighthawk.spring_portfolio.mvc.prequiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* 
import com.nighthawk.spring_portfolio.mvc.prequiz.PrequizJpaRepository;
import com.nighthawk.spring_portfolio.mvc.prequiz.prequiz;

*/

import java.util.*;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/Prequiz")
public class PrequizApiController {

    @Autowired
    PrequizJpaRepository repository;

    @GetMapping("/create/{quizResults}") //gets results
    public Prequiz displayResults(Long id, String level) {
        /* 
        String username = getId();
        Prequiz result = new Prequiz(id, level);
        repository.save(result);
        return new ResponseEntity<>(repository.findById(username), HttpStatus.OK);
        */
        public String toString() {
            return "{" +
                    "Id='" + id + '\'' +
                    ", level=" + level +
                    '}';
        }
    
        if (id.isPresent()) {
            return ResponseEntity.ok().toString;
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/Prequiz/questions") //displays results
    public Prequiz getQuestions(Long id) {
        return new ResponseEntity<>(repository.computeRatingPrequiz(), HttpStatus.OK);
    }


    public void saveData( ) {
        repository.save(Prequiz);
    }

   
    
}