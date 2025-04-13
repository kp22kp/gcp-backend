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
//    @Autowired
//    private ITheaterService theaterService;

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


    @Override
    public int getSeatsAvailable(String theaterSelected, String date, String time) {
        Theater theater = getTheaterName(theaterSelected);
        List<Integer> seatAvailableByShow = theater.getSeatAvailable();
        int indexOfSeatsAvailable = getIndexOfSeatsAvailable(theaterSelected, date, time);
        return seatAvailableByShow.get(indexOfSeatsAvailable);
    }

    @Override
    public void setSeatsAvailable(String theaterSelected, int availableSeats, int seatsNeeded, String selectedDate, String selectedTime) {
        Theater theater = getTheaterName(theaterSelected);
        List<Integer> seatAvailableByShow = theater.getSeatAvailable();
        int indexOfSeatsAvailable = getIndexOfSeatsAvailable(theaterSelected, selectedDate, selectedTime);
        if (indexOfSeatsAvailable != -1) {
            seatAvailableByShow.set(indexOfSeatsAvailable, availableSeats - seatsNeeded);
            theater.setSeatAvailable(seatAvailableByShow);
            theaterRepository.save(theater);
        }

    }

    @Override
    public void setSeatsAvailable(String theaterSelected, int seatsAvailable,int seatsNeeded) {
        Theater theater = getTheaterName(theaterSelected);
        if (theater != null) {
            theater.setSeatsAvailable(seatsAvailable - seatsNeeded);
            theaterRepository.save(theater);
        }
    }

    @Override
    public int getTotalSeats(String theaterSelected) {
        Theater theater = getTheaterName(theaterSelected);
        if (theater != null) {
            return theater.getTotalSeats();
        }
        return 0;
    }

    public String seatAllocation(int numberOfTickets, int availableTickets, int seatsBooked) {
        int seatNumber = seatsBooked+1;
        if (numberOfTickets > availableTickets) {
            return "Not enough tickets available";
        }

        StringBuilder seatAllocation = new StringBuilder();
        int seatsPerRow = 10;

        for (int i = 0; i < numberOfTickets; i++) {
            int rowIndex = (seatNumber - 1) / seatsPerRow;
            String row = generateRowName(rowIndex);
            seatAllocation.append(row).append("-").append((seatNumber - 1) % seatsPerRow + 1).append(", ");
            seatNumber++;
        }

        if (!seatAllocation.isEmpty()) {
            seatAllocation.setLength(seatAllocation.length() - 2);
        }

        return seatAllocation.toString();
    }

    private String generateRowName(int index) {
        StringBuilder rowName = new StringBuilder();
        while (index >= 0) {
            rowName.insert(0, (char) ('A' + index % 26));
            index = index / 26 - 1;
        }
        return rowName.toString();
    }

    public int getIndexOfSeatsAvailable(String theaterSelected, String date, String time) {
        Theater theater = getTheaterName(theaterSelected);
        if (theater != null) {
            List<String> dateOfShows = theater.getDateOfShows();
            List<String> timing = theater.getTiming();
            for (int i = 0; i < dateOfShows.size(); i++) {
                if (dateOfShows.get(i).equals(date)) {
                    for (int j = 0; j < timing.size(); j++) {
                        if (timing.get(j).equals(time)) {
                            return i * timing.size() + j;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public Theater getTheaterName(String theaterSelected) {
        List<Theater> theaters = (List<Theater>) theaterRepository.findAll();
        for (Theater theater : theaters) {
            if (theater.getTheaterName().equals(theaterSelected)) {
                return theater;
            }
        }
        return null;
    }
}
