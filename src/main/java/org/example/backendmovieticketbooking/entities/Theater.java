package org.example.backendmovieticketbooking.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Theater {
    @Id
    private int theaterId;
    private String theaterName;
    private int totalSeats;

    @ElementCollection
    private List<Integer> seatAvailable;

    private int seatsAvailable;

    @ElementCollection
    private List<String> timing;

    private int runningMovieId;

    @ElementCollection
    private List<String> dateOfShows;

    public Theater(int theaterId, String theaterName, int totalSeats, List<String> timing, int runningMovieId, List<String> dateOfShows) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.totalSeats = totalSeats;
        this.seatsAvailable = totalSeats;
        this.timing = timing;
        this.dateOfShows = dateOfShows;
        this.runningMovieId = runningMovieId;
        initializeSeatsGrid();
    }

    public void initializeSeatsGrid() {
        if (seatAvailable == null) {
            seatAvailable = new ArrayList<>(); // Initialize the list
        }
        for (int i = 0; i < dateOfShows.size(); i++) {
            for (int j = 0; j < timing.size(); j++) {
                seatAvailable.add(totalSeats); // Initialize with total seats
            }
        }
    }

}
