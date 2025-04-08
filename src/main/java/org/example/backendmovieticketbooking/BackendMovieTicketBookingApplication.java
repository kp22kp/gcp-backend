package org.example.backendmovieticketbooking;

import org.example.backendmovieticketbooking.entities.Movie;
import org.example.backendmovieticketbooking.repository.IMovieRepository;
import org.example.backendmovieticketbooking.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class BackendMovieTicketBookingApplication implements CommandLineRunner {

	@Autowired
	private IMovieRepository movieRepository;



	public static void main(String[] args) {
		SpringApplication.run(BackendMovieTicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Movie movie1 = new Movie(1, "Inception", 2010, "Sci-Fi", "English");
		Movie movie2 = new Movie(2, "Parasite", 2019, "Thriller", "Korean");
		Movie movie3 = new Movie(3, "The Godfather", 1972, "Crime", "English");
		Movie movie4 = new Movie(4, "Spirited Away", 2001, "Animation", "Japanese");
		Movie movie5 = new Movie(5, "Interstellar", 2014, "Sci-Fi", "English");

		// Example: Save movies to the repository
		movieRepository.save(movie1);
		movieRepository.save(movie2);
		movieRepository.save(movie3);
		movieRepository.save(movie4);
		movieRepository.save(movie5);
	}
}
