package com.nighthawk.spring_portfolio.mvc.prequiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrequizJpaRepository extends JpaRepository<Prequiz,Long> {
    Prequiz findById(String name);
    Prequiz getId(Long id);
    String computeRatingPrequiz();
}
