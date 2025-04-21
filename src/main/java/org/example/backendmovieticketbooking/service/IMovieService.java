package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entitie.Movie;
import java.util.List;


public interface IMovieService {
    Movie addMovie(Movie movie);
    Movie getMovieById(Integer id);
    List<Movie> getAllMovies();
    Movie updateMovie(Movie movie);
    boolean deleteMovie(Integer id);
}
