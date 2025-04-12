package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entities.Users;

public interface IUserService {
    Users addUser(Users user);
    Users getUserById(int id);
    Users updateUser(Users user);
    boolean deleteUserById(int id);
}
