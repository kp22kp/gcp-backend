package org.example.backendmovieticketbooking.service;

import org.example.backendmovieticketbooking.entities.Theater;
import org.example.backendmovieticketbooking.repository.ITheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TheaterService implements ITheaterService {
    @Autowired
    private ITheaterRepository theaterRepository;

    @Override
    public Theater addTheater(Theater theater) {
        theaterRepository.save(theater);
        return theater;
    }

    @Override
    public Theater updateTheater(Theater theater) {
        theaterRepository.save(theater);
        return theater;
    }

    @Override
    public Boolean deleteTheater(int theaterId) {
        if(theaterRepository.existsById(theaterId)){
            theaterRepository.deleteById(theaterId);
            return true;
        }
        return false;
    }

    @Override
    public Theater getTheater(int theaterId) {
        if(theaterRepository.existsById(theaterId)) {
            return theaterRepository.findById(theaterId).get();
        }
        return null;
    }

    @Override
    public List<Theater> findAll() {
        theaterRepository.findAll();
        return (List<Theater>) theaterRepository.findAll();
    }
}
