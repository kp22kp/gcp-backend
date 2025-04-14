package org.example.backendmovieticketbooking.controller;

import org.example.backendmovieticketbooking.entities.Theater;
import org.example.backendmovieticketbooking.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {
    @Autowired
    private ITheaterService theaterService;

    @PostMapping("")
    public Theater addTheater(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }

    @PutMapping("")
    public Theater updateTheater(@RequestBody Theater theater) {
        return theaterService.updateTheater(theater);
    }

    @DeleteMapping("/{theaterId}")
    public String deleteTheater(@PathVariable int theaterId) {
        if(theaterService.deleteTheater(theaterId)){
            return "Theater deleted successfully";
        }
        return "Theater not found";
    }

    @GetMapping("/{movieId}")
    public List<Theater> getTheater(@PathVariable int movieId) {
        return theaterService.getTheater(movieId);
    }

    @GetMapping("")
    public List<Theater> getAllTheater() {
        return theaterService.findAll();
    }

}

