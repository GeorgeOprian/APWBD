package com.awbd.lab7.services;

import com.awbd.lab7.domain.Movie;
import com.awbd.lab7.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;

    @Override
    public Optional<Movie> findById(String id) {
        return movieRepository.findById(id);
    }


    @Override
    public void deleteById(String id) {
        movieRepository.deleteById(id);
    }


    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Page<Movie> findPaginated(Pageable pageable) {
        List<Movie> movies = movieRepository.findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Movie> list;

        if (movies.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, movies.size());
            list = movies.subList(startItem, toIndex);
        }

        Page<Movie> moviePage
                = new PageImpl<Movie>(list, PageRequest.of(currentPage, pageSize), movies.size());

        return moviePage;
    }
}

