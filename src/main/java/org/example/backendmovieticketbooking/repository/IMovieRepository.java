package org.example.backendmovieticketbooking.repository;

import org.example.backendmovieticketbooking.entitie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
}
