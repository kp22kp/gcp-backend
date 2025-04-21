package org.example.backendmovieticketbooking.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int yearOfRelease;
    private String genre;
    private String language;
    private String imageUrl;
    @Version
    private Integer version;

    public Movie(String name, int yearOfRelease, String genre, String language, String imageUrl) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.genre = genre;
        this.language = language;
        this.imageUrl = imageUrl;
    }
}