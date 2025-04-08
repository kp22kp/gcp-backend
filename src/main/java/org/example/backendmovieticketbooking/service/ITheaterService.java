package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entities.Theater;

import java.util.List;

public interface ITheaterService {
    public Theater addTheater(Theater theater);
    public Theater updateTheater(Theater theater);
    public Boolean deleteTheater(int theaterId);
    public Theater getTheater(int theaterId);
    public List<Theater> findAll();
}
