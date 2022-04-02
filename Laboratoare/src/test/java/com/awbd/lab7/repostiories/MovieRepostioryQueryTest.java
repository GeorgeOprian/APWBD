package com.awbd.lab7.repostiories;

import com.awbd.lab7.domain.Movie;
import com.awbd.lab7.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataMongoTest
@Slf4j
public class MovieRepostioryQueryTest {

    @Autowired
    MovieRepository movieRepository;

    @Test
    public void findByYearBetween() {
        List<Movie> movies = movieRepository.findByYearBetween(1960,1970);
        assertFalse(movies.isEmpty());
        log.info("findByTitleLike ...");
        movies.forEach(movie -> log.info(movie.toString()));
    }



    @Test
    public void findMoviesByRegexpTitle() {
        List<Movie> movies = movieRepository.findMoviesByRegexpTitle("^T");
        assertFalse(movies.isEmpty());
        log.info("findByTitleLike ...");
        movies.forEach(movie -> log.info(movie.toString()));
    }
}
