package org.example.backendmovieticketbooking.repository;

import org.example.backendmovieticketbooking.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
}
