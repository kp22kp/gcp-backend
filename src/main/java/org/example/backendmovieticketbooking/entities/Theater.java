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
    private List<String> Timing;


}
