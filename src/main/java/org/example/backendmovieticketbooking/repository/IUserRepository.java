package org.example.backendmovieticketbooking.repository;

import org.example.backendmovieticketbooking.entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<Users, Integer> {

}
