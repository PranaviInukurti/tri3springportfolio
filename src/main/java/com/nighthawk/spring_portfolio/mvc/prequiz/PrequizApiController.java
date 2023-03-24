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


    @GetMapping("/api/Prequiz/questions") 
    public Prequiz getQuestions(Long id) {
        return (repository.findById(id).isPresent())
                ? repository.findById(id).get()
                : null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteRecipes(@PathVariable Long id) {
        repository.deleteById(id);  
        return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
    }

    @CreateMapping("/uuihiuh/")
    public recipes getRecipe(Long id) {
        return (repository.findById(id).isPresent())
                ? repository.findById(id).get()
                : null;
    }



    public void saveData( ) {
        repository.save();
    }

   
    
}