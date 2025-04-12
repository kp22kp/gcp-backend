package org.example.backendmovieticketbooking.controller;

import org.example.backendmovieticketbooking.entities.User;
import org.example.backendmovieticketbooking.service.MovieService;
import org.example.backendmovieticketbooking.service.TheaterService;
import org.example.backendmovieticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user") // Correctly define the base path
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheaterService theaterService;

    @PostMapping("")
    public User addUser(@RequestBody User user) { // Use @RequestBody to map JSON to User
        System.out.println("addUser called");
        int seatsNeeded = user.getNoOfSeatsBooked();
        int availableSeats = theaterService.getSeatsAvailable(user.getTheaterSelected());
        if (seatsNeeded > availableSeats) {
            throw new RuntimeException("Not enough seats available");
        }
        theaterService.setSeatsAvailable(user.getTheaterSelected(), seatsNeeded);
        String seats = seatAllocation(seatsNeeded, availableSeats);
        user.setSeatsAllocated(seats);
        userService.addUser(user);
        return user;
    }

    public String seatAllocation(int numberOfTickets, int availableTickets) {
        if (numberOfTickets > availableTickets) {
            return "Not enough tickets available";
        }

        StringBuilder seatAllocation = new StringBuilder();
        int seatNumber = 1;
        int seatsPerRow = 10;

        for (int i = 0; i < numberOfTickets; i++) {
            int rowIndex = (seatNumber - 1) / seatsPerRow;
            String row = generateRowName(rowIndex);
            seatAllocation.append(row).append("-").append((seatNumber - 1) % seatsPerRow + 1).append(", ");
            seatNumber++;
        }

        if (seatAllocation.length() > 0) {
            seatAllocation.setLength(seatAllocation.length() - 2);
        }

        return seatAllocation.toString();
    }

    private String generateRowName(int index) {
        StringBuilder rowName = new StringBuilder();
        while (index >= 0) {
            rowName.insert(0, (char) ('A' + index % 26));
            index = index / 26 - 1;
        }
        return rowName.toString();
    }
}