package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;


    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody(required = true) Movie movie){

        movieService.addAllMovies(movie);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody(required = true) Director director){
        movieService.addAllDirectors(director);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("moviename") String movieName,@RequestParam("directorname")
                                               String directorName){
        movieService.addAllDirectorMovies(movieName,directorName);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getMovies(name),HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getDirectors(name),HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-movies-by-director-name/{name}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(@PathVariable("name") String name){
        return new ResponseEntity<>(movieService.getDirectorMovies(name),HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorname") String name){
        movieService.deleteDirectorMovie(name);
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectorMovies();
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }






}
