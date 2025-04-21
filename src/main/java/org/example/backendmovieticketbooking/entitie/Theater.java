package org.example.backendmovieticketbooking.entitie;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterId;
    private String theaterName;
    private int totalSeats;

    @ElementCollection
    private List<Integer> seatAvailable;

    @ElementCollection
    private List<String> showTiming;

    private int runningMovieId;

    @ElementCollection
    private List<String> dateOfShows;

    @Column(length = 1000)
    private String theaterUrl;

//    public Theater() {
//        initializeSeatsGrid();
//    }

    public Theater(String theaterName, int totalSeats, List<String> timing, int runningMovieId, List<String> dateOfShows, String theaterUrl) {
        this.theaterName = theaterName;
        this.totalSeats = totalSeats;
        this.showTiming = timing;
        this.dateOfShows = dateOfShows;
        this.runningMovieId = runningMovieId;
        this.theaterUrl = theaterUrl;
        initializeSeatsGrid();
        System.out.println("addUser called");
    }

    public void initializeSeatsGrid() {
        if (seatAvailable == null) {
            seatAvailable = new ArrayList<>(); // Initialize the list
        } else {
            seatAvailable.clear(); // Clear the list to avoid duplication
        }
        for (int i = 0; i < dateOfShows.size(); i++) {
            for (int j = 0; j < showTiming.size(); j++) {
                seatAvailable.add(totalSeats); // Initialize with total seats
            }
        }
    }

}
