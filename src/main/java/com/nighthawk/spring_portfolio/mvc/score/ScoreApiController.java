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

    /*
    GET List of People
     */
    @GetMapping("/")
    public ResponseEntity<List<Score>> getScore() {
        return new ResponseEntity<>( repository.findAllByOrderByEmailAsc(), HttpStatus.OK);
    }

  
}
