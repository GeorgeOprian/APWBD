package com.awbd.lab7.controllers;

import com.awbd.lab7.domain.Movie;
import com.awbd.lab7.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping("/movie/info/{id}")
    public String showById(@PathVariable String id, Model model){
        Optional<Movie> movieOpt = movieService.findById(id);
        if (movieOpt.isPresent()) {
            model.addAttribute("movie", movieOpt.get());
            return "info";
        }
        else {
            model.addAttribute("id", id);
            return "nomovie";
        }
    }

    @RequestMapping("/movie/delete/{id}")
    public String deleteById(@PathVariable String id, Model model){
        Optional<Movie> movieOpt = movieService.findById(id);
        if (movieOpt.isPresent()) {
            movieService.deleteById(id);
            return "redirect:/index";
        }
        else {
            model.addAttribute("id", id);
            return "nomovie";
        }
    }

}

