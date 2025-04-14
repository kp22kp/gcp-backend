package org.example.backendmovieticketbooking.repository;

import org.example.backendmovieticketbooking.entities.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITheaterRepository extends CrudRepository<Theater, Integer> {
    List<Theater> getTheaterByRunningMovieId(int runningMovieId);
}
