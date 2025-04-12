package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entities.User;
import org.example.backendmovieticketbooking.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userRepository.findById(id).map(user -> {;
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
}
