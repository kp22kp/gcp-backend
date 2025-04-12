package org.example.backendmovieticketbooking;

import org.example.backendmovieticketbooking.entities.Movie;
import org.example.backendmovieticketbooking.entities.Theater;
import org.example.backendmovieticketbooking.repository.IMovieRepository;
import org.example.backendmovieticketbooking.repository.ITheaterRepository;
import org.example.backendmovieticketbooking.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class BackendMovieTicketBookingApplication implements CommandLineRunner {

	@Autowired
	private IMovieRepository movieRepository;

	@Autowired
	ITheaterRepository theaterRepository;



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

		Theater theater1 = new Theater(1, "Grand Cinema", 200, 200, Arrays.asList("10:00 AM", "1:00 PM", "4:00 PM"), 1, Arrays.asList("2023-10-01", "2023-10-02", "2023-10-03"));
		Theater theater2 = new Theater(2, "Elite Theater", 150, 150, Arrays.asList("11:00 AM", "2:00 PM", "5:00 PM"), 2, Arrays.asList("2023-10-04", "2023-10-05", "2023-10-06"));
		Theater theater3 = new Theater(3, "Galaxy Multiplex", 300, 300, Arrays.asList("9:00 AM", "12:00 PM", "3:00 PM"), 3, Arrays.asList("2023-10-07", "2023-10-08", "2023-10-09"));

		theaterRepository.save(theater1);
		theaterRepository.save(theater2);
		theaterRepository.save(theater3);

	}
}
