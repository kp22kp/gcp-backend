package org.example.backendmovieticketbooking.controller;


import org.example.backendmovieticketbooking.entities.Movie;
import org.example.backendmovieticketbooking.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @PostMapping("")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.addMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PutMapping("")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        if (movieService.deleteMovie(id)) {
            return "successfully deleted";
        }
        return "Movie Not Found";
    }
}
