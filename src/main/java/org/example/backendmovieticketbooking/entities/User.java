package org.example.backendmovieticketbooking.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private int userId;
    private String userName;
    private String movieSelected;
    private String theaterSelected;
    private int noOfSeatsBooked;
    private String seatsAllocated;
}
