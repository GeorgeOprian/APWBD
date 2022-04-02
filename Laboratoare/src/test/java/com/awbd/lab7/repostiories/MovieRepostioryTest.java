package com.awbd.lab7.repostiories;

import com.awbd.lab7.domain.Comment;
import com.awbd.lab7.domain.Movie;
import com.awbd.lab7.repositories.CommentRepository;
import com.awbd.lab7.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;

@DataMongoTest
@Slf4j
public class MovieRepostioryTest {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    CommentRepository commentRepository;

    @ParameterizedTest
    @ValueSource(strings = {"Civilization", "The Birth of a Nation"})
    public void findByTitle(String title) {
        List<Movie> movies = movieRepository.findByTitle(title);
        assertFalse(movies.isEmpty());
        log.info("findByTitleLike ...");
        movies.forEach(movie -> log.info(movie.toString()));
    }

    @Rollback(false)
    @ParameterizedTest
    @ValueSource(strings = {"573a1390f29313caabcd6223"})
    public void findById(String id) {
        Optional<Movie> movieOpt = movieRepository.findById(id);
        assertFalse(movieOpt.isEmpty());
        log.info("findByTitleLike ...");
        log.info(movieOpt.get().toString());

        Movie movie = movieOpt.get();
        Comment comment = new Comment();
        comment.setId(UUID.randomUUID().toString());
        comment.setText("nice movie");

        commentRepository.save(comment);

        movie.getComments().add(comment);
        movie.setTitle("The Poor Little Rich Girl2");
        movieRepository.save(movie);
    }

}
