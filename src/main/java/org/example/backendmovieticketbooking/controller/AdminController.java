package org.example.backendmovieticketbooking.controller;

import org.example.backendmovieticketbooking.entities.Movie;
import org.example.backendmovieticketbooking.entities.Theater;
import org.example.backendmovieticketbooking.service.IMovieService;
import org.example.backendmovieticketbooking.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private ITheaterService theaterService;
    @Autowired
    private IMovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.addMovie(movie);
        return ResponseEntity.ok(createdMovie);
    }

    @GetMapping("/find-movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/all-movies")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @PutMapping("/update-movie")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        Movie updatedMovie = movieService.updateMovie(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/delete-movie/{id}")
    public boolean deleteMovie(@PathVariable Integer id) {
        return movieService.deleteMovie(id);
    }

    //---------------------------< movie || theater >---------------------------------------//

    @PostMapping("/add-theater")
    public Theater addStudent(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }

    @PutMapping("/update-theater")
    public Theater updateTheater(@RequestBody Theater theater) {
        return theaterService.updateTheater(theater);
    }

    @DeleteMapping("/delete-theater/{theaterId}")
    public String deleteTheater(@PathVariable int theaterId) {
        if(theaterService.deleteTheater(theaterId)){
            return "Theater deleted successfully";
        }
        return "Theater not found";
    }

    @GetMapping("/find-theater/{theaterId}")
    public Theater getTheater(@PathVariable int theaterId) {
        return theaterService.getTheater(theaterId);
    }

    @GetMapping("/all-theater")
    public List<Theater> getAllTheater() {
        return theaterService.findAll();
    }

}
