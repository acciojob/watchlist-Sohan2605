package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepo;

    public void addAllMovies(Movie movie){
        movieRepo.addMoviesToDB(movie);
    }

    public void addAllDirectors(Director director){
        movieRepo.addDirectorsToDB(director);
    }

    public void addAllDirectorMovies(String movieName,String directorName){
        movieRepo.addDirectorMoviesToDB(movieName,directorName);
    }

    public Movie getMovies(String name){
        return movieRepo.getMoviesFromDB(name);
    }

    public Director getDirectors(String name){
        return movieRepo.getDirectorsFromDB(name);
    }

    public List<Movie> getDirectorMovies(String name){
        return movieRepo.getDirectorMoviesFromDB(name);
    }

    public List<Movie> getAllMovies(){
        return movieRepo.getAllMoviesFromDB();
    }

    public void deleteDirectorMovie(String name){
        movieRepo.deleteDirectorMoviesFromDB(name);
    }

    public void deleteAllDirectorMovies(){
        movieRepo.deleteAllDirectorMoviesFromDB();
    }
}
