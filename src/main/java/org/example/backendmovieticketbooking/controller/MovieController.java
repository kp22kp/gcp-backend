package org.example.backendmovieticketbooking.controller;

import org.example.backendmovieticketbooking.entitie.Movie;
import org.example.backendmovieticketbooking.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

//    Add Movies
    @PostMapping("")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.addMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

//    Get Movie By Id
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

//    Get All Movies
    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

//    Update
    @PutMapping("")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(movie);
        return ResponseEntity.ok(updatedMovie);
    }

//    Delete
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        if (movieService.deleteMovie(id)) {
            return "successfully deleted";
        }
        return "Movie Not Found";
    }
}
