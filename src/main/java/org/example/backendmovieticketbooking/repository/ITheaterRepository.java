package org.example.backendmovieticketbooking.repository;

import org.example.backendmovieticketbooking.entities.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITheaterRepository extends CrudRepository<Theater, Integer> {
}
