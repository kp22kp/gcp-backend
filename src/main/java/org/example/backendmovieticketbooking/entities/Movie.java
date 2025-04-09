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

public class Movie {
    @Id
    private int id;
    private String name;
    private int yearOfRelease;
    private String genre;
    private String language;
}