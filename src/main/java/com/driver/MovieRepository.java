package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
@Repository
public class MovieRepository {

    Map<String,Movie> movies=new HashMap<>();

    Map<String,Director> directors=new HashMap<>();

    Map<String,List<Movie>> directorMovies=new HashMap<>();

    public void addMoviesToDB(Movie movie){
        movies.put(movie.getName(),movie);
    }

    public void addDirectorsToDB(Director director){
        directors.put(director.getName(),director);
    }

    public void addDirectorMoviesToDB(String movieName,String directorName){

            List<Movie> directorMovieList=new ArrayList<>();
            if(directorMovies.containsKey(directorName)){
                 directorMovieList=directorMovies.get(directorName);
            }

            if(movies.containsKey(movieName)){
                directorMovieList.add(movies.get(movieName));
                directorMovies.put(directorName,directorMovieList);
            }
    }

    public Movie getMoviesFromDB(String name){
        Movie movie=movies.get(name);
        return movie;
    }

    public Director getDirectorsFromDB(String name){
        Director director=directors.get(name);
        return director;
    }

    public List<Movie> getDirectorMoviesFromDB(String name){
        List<Movie> movieList=directorMovies.get(name);
        return movieList;
    }

    public List<Movie> getAllMoviesFromDB(){
        List<Movie> moviesList=new ArrayList<>();
        for(Movie movie:movies.values()){
            moviesList.add(movie);
        }
        return moviesList;
    }

    public void deleteDirectorMoviesFromDB(String name){
        directorMovies.remove(name);
    }
    public void deleteAllDirectorMoviesFromDB(){
        for(String key:directorMovies.keySet()){
            List<Movie> listOfMovies=directorMovies.get(key);
            for(int i=0;i<listOfMovies.size();i++){
                movies.remove(listOfMovies.get(i).getName());
            }
            directors.remove(key);
            directorMovies.remove(key);
        }
    }
}
