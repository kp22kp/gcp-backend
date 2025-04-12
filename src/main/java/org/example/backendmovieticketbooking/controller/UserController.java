package org.example.backendmovieticketbooking.controller;


import org.example.backendmovieticketbooking.entities.Users;
import org.example.backendmovieticketbooking.service.TheaterService;
import org.example.backendmovieticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user") // Correctly define the base path
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TheaterService theaterService;



    @PostMapping("")
    public Users addUser(@RequestBody Users user) { // Use @RequestBody to map JSON to User
        System.out.println("addUser called");
        int seatsNeeded = user.getNoOfSeatsBooked();
        int availableSeats = theaterService.getSeatsAvailable(user.getTheaterSelected(), user.getSelectedDate(), user.getSelectedTime());
        int totalSeats = theaterService.getTotalSeats(user.getTheaterSelected());
        if (seatsNeeded > availableSeats) {
            throw new RuntimeException("enough seats Not available");
        }
        if (seatsNeeded > 10) {
            throw new RuntimeException("Can only book 10 seats at a time");
        }
        int seatsBooked = totalSeats - availableSeats;
        theaterService.setSeatsAvailable(user.getTheaterSelected(),availableSeats, seatsNeeded);
        theaterService.setSeatsAvailable(user.getTheaterSelected(),availableSeats, seatsNeeded, user.getSelectedDate(), user.getSelectedTime());
        String seats = seatAllocation(seatsNeeded, availableSeats, seatsBooked);
        user.setSeatsAllocated(seats);
        userService.addUser(user);
        return user;
    }

    public String seatAllocation(int numberOfTickets, int availableTickets, int seatsBooked) {
        int seatNumber = seatsBooked+1;
        if (numberOfTickets > availableTickets) {
            return "Not enough tickets available";
        }

        StringBuilder seatAllocation = new StringBuilder();
        int seatsPerRow = 10;

        for (int i = 0; i < numberOfTickets; i++) {
            int rowIndex = (seatNumber - 1) / seatsPerRow;
            String row = generateRowName(rowIndex);
            seatAllocation.append(row).append("-").append((seatNumber - 1) % seatsPerRow + 1).append(", ");
            seatNumber++;
        }

        if (!seatAllocation.isEmpty()) {
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

    @GetMapping("")
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

}