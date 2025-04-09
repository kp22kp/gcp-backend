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
@RequestMapping("/api/v1/admin")
public class AdminController {
}
