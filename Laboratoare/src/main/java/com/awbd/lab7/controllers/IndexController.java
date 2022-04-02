package com.awbd.lab7.controllers;

import com.awbd.lab7.domain.Movie;
import com.awbd.lab7.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {

    /*
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }

     */
    @Autowired
    MovieService movieService;

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies",movies);
        System.out.println(movies.size());
        return "index";
    }

    @RequestMapping({"/home"})
    public String getMoviePage(Model model,
                               @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Movie> moviePage = movieService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("moviePage",moviePage);

        return "home";
    }


}
