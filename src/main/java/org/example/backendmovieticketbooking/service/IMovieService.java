package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entities.Movie;

import java.util.List;

public interface IMovieService {
    Movie addMovie(Movie movie);
    Movie getMovieById(Integer id);
    List<Movie> getAllMovies();
    Movie updateMovie(Integer id, Movie movie);
    void deleteMovie(Integer id);
}
