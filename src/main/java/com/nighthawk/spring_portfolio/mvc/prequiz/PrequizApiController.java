
package com.nighthawk.spring_portfolio.mvc.prequiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// import com.nighthawk.spring_portfolio.mvc.prequiz.PrequizJpaRepository;
// import com.nighthawk.spring_portfolio.mvc.prequiz.prequiz;



import java.util.*;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/api/Prequiz")
public class PrequizApiController {

     
    @Autowired
    PrequizJpaRepository repository;
    

    
    @GetMapping("/create/{quizResults}") //gets results
    public ResponseEntity<Prequiz> displayResults(@PathVariable Long id, @PathVariable String level) {
        Prequiz result = new Prequiz(10, 8, 9, level, id);
        repository.save(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /* 
    @GetMapping("/api/Prequiz/questions") //displays results
    public ResponseEntity<String> getQuestions() {
        String rating = repository.computeRatingPrequiz();
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }
    */

    // Other methods for saving and retrieving data
    
}
