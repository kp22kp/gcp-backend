package org.example.backendmovieticketbooking.repository;

import org.example.backendmovieticketbooking.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

}
