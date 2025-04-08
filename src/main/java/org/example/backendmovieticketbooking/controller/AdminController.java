package org.example.backendmovieticketbooking.controller;

import org.example.backendmovieticketbooking.entities.Theater;
import org.example.backendmovieticketbooking.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private ITheaterService theaterService;

    @PostMapping("/AddTheater")
    public Theater addStudent(@RequestBody Theater theater) {
        return theaterService.addTheater(theater);
    }

    @PutMapping("/UpdateTheater")
    public Theater updateTheater(@RequestBody Theater theater) {
        return theaterService.updateTheater(theater);
    }

    @DeleteMapping("/DeleteTheater/{theaterId}")
    public String deleteTheater(@PathVariable int theaterId) {
        if(theaterService.deleteTheater(theaterId)){
            return "Theater deleted successfully";
        }
        return "Theater not found";
    }

    @GetMapping("/GetTheater/{theaterId}")
    public Theater getTheater(@PathVariable int theaterId) {
        return theaterService.getTheater(theaterId);
    }

    @GetMapping("/GetAllTheater")
    public List<Theater> getAllTheater() {
        return theaterService.findAll();
    }

}
