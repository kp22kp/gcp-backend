package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entities.Users;
import org.example.backendmovieticketbooking.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUserById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userRepository.findById(id).map(user -> {;
            userRepository.delete(user);
            return true;
        }).orElse(false);
    }
    public List<Users> getAllUsers() {
        return (List<Users>) userRepository.findAll();
    }
}
