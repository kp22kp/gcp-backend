package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entities.Theater;
import java.util.List;


public interface ITheaterService {
    Theater addTheater(Theater theater);
    Theater updateTheater(Theater theater);
    Boolean deleteTheater(int theaterId);
    List<Theater> getTheater(int movieId);
    List<Theater> findAll();
    int getTotalSeats(String theaterSelected);
    int getSeatsAvailable(String theaterSelected, String date, String time);
    void setSeatsAvailable(String theaterSelected, int availableSeats, int seatsNeeded, String selectedDate, String selectedTime);
}
