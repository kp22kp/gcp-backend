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
		Movie movie6 = new Movie(6, "Baahubali: The Beginning", 2015, "Action", "Telugu", "https://br.web.img2.acsta.net/pictures/16/02/04/17/38/212843.jpg");
		Movie movie7 = new Movie(7, "3 Idiots", 2009, "Comedy-Drama", "Hindi", "https://th.bing.com/th/id/OIP.hcidl6JZI-Afn8LHvmr7bgHaLH?rs=1&pid=ImgDetMain");
		Movie movie8 = new Movie(8, "GOAT", 2024, "Action", "Tamil", "https://static.moviecrow.com/gallery/20240116/224657-goat3.jpeg");
		Movie movie9 = new Movie(9, "Dangal", 2016, "Sports-Drama", "Hindi", "https://th.bing.com/th/id/OIP.avPjML4GTJw6gYux9A6iyQHaJ4?rs=1&pid=ImgDetMain");
		Movie movie10 = new Movie(10, "RRR", 2022, "Action-Drama", "Telugu", "https://th.bing.com/th/id/OIP.04gVePrs6zsGVNt6S_Za9QHaKf?rs=1&pid=ImgDetMain");
		Movie movie11 = new Movie(11, "Brahmastra Part One: Shiva", 2022, "Action-Drama", "Hindi", "https://www.themoviedb.org/t/p/original/4kZW6qBBf8djV7Gbe2vpJVUbNR8.jpg");
		Movie movie12 = new Movie(12, "Avengers: Endgame", 2019, "Action - Sci-fi", "English", "https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/9/91/Endgame_Poster_2.jpg/revision/latest?cb=20190314215527");


		// Example: Save movies to the repository
		movieRepository.save(movie1);
		movieRepository.save(movie2);
		movieRepository.save(movie3);
		movieRepository.save(movie4);
		movieRepository.save(movie5);
	}
}
