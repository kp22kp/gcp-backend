package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entities.User;

public interface IUserService {
    User addUser(User user);
    User getUserById(int id);
    User updateUser(User user);
    boolean deleteUserById(int id);
}
