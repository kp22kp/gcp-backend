package org.example.backendmovieticketbooking;

import org.example.backendmovieticketbooking.entities.Movie;
import org.example.backendmovieticketbooking.entities.Theater;
import org.example.backendmovieticketbooking.repository.IMovieRepository;
import org.example.backendmovieticketbooking.repository.ITheaterRepository;
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
	private ITheaterRepository theaterRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendMovieTicketBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Movie movie1 = new Movie("Inception", 2010, "Sci-Fi", "English","https://m.media-amazon.com/images/M/MV5BMjExMjkwNTQ0Nl5BMl5BanBnXkFtZTcwNTY0OTk1Mw@@._V1_.jpg");
		Movie movie2 = new Movie( "Parasite", 2019, "Thriller", "Korean","https://th.bing.com/th/id/OIP.pYvYTRli-e0VirVDcajBGgHaLG?rs=1&pid=ImgDetMain");
		Movie movie3 = new Movie( "The Godfather", 1972, "Crime", "English","https://posterspy.com/wp-content/uploads/2019/04/godfather.jpg");
		Movie movie4 = new Movie( "Spirited Away", 2001, "Animation", "Japanese","https://image.tmdb.org/t/p/original/qH2f0e19oklRgiq8vpnRuaXkuT.jpg");
		Movie movie5 = new Movie( "Interstellar", 2014, "Sci-Fi", "English","https://s3.amazonaws.com/nightjarprod/content/uploads/sites/130/2021/08/19085635/gEU2QniE6E77NI6lCU6MxlNBvIx-scaled.jpg");
		Movie movie6 = new Movie( "Baahubali: The Beginning", 2015, "Action", "Telugu", "https://br.web.img2.acsta.net/pictures/16/02/04/17/38/212843.jpg");
		Movie movie7 = new Movie( "3 Idiots", 2009, "Comedy-Drama", "Hindi", "https://th.bing.com/th/id/OIP.hcidl6JZI-Afn8LHvmr7bgHaLH?rs=1&pid=ImgDetMain");
		Movie movie8 = new Movie( "GOAT", 2024, "Action", "Tamil", "https://static.moviecrow.com/gallery/20240116/224657-goat3.jpeg");
		Movie movie9 = new Movie( "Dangal", 2016, "Sports-Drama", "Hindi", "https://th.bing.com/th/id/OIP.avPjML4GTJw6gYux9A6iyQHaJ4?rs=1&pid=ImgDetMain");
		Movie movie10 = new Movie( "RRR", 2022, "Action-Drama", "Telugu", "https://th.bing.com/th/id/OIP.04gVePrs6zsGVNt6S_Za9QHaKf?rs=1&pid=ImgDetMain");
		Movie movie11 = new Movie( "Brahmastra Part One: Shiva", 2022, "Action-Drama", "Hindi", "https://www.themoviedb.org/t/p/original/4kZW6qBBf8djV7Gbe2vpJVUbNR8.jpg");
		Movie movie12 = new Movie( "Avengers: Endgame", 2019, "Action - Sci-fi", "English", "https://vignette.wikia.nocookie.net/marvelcinematicuniverse/images/9/91/Endgame_Poster_2.jpg/revision/latest?cb=20190314215527");
		movieRepository.save(movie1);
		movieRepository.save(movie2);
		movieRepository.save(movie3);
		movieRepository.save(movie4);
		movieRepository.save(movie5);
		movieRepository.save(movie6);
		movieRepository.save(movie7);
		movieRepository.save(movie8);
		movieRepository.save(movie9);
		movieRepository.save(movie10);
		movieRepository.save(movie11);
		movieRepository.save(movie12);

		Theater theater1 = new Theater(1, "Grand Cinema", 200, Arrays.asList("10:00 AM", "1:00 PM", "4:00 PM"), 1, Arrays.asList("2023-10-01", "2023-10-02", "2023-10-03"),"https://th.bing.com/th/id/OIP.4EXPLgZqFe8PFaWhMNFYkgHaJg?w=220&h=283&c=8&rs=1&qlt=90&o=6&dpr=2&pid=3.1&rm=2");
		Theater theater2 = new Theater(2, "Elite Theater", 150, Arrays.asList("11:00 AM", "2:00 PM", "5:00 PM"), 2, Arrays.asList("2023-10-04", "2023-10-05", "2023-10-06"), "https://th.bing.com/th/id/OIP.aU_VnMXhUVC8cwzsiY4LbgHaFZ?w=292&h=213&c=8&rs=1&qlt=90&o=6&dpr=2&pid=3.1&rm=2");
		Theater theater3 = new Theater(3, "Galaxy Multiplex", 300, Arrays.asList("9:00 AM", "12:00 PM", "3:00 PM"), 3, Arrays.asList("2023-10-07", "2023-10-08", "2023-10-09"),"https://th.bing.com/th/id/OIP.b8WvZgdajytlosm15GrNyAHaFj?w=288&h=216&c=8&rs=1&qlt=90&o=6&dpr=2&pid=3.1&rm=2");
		Theater theater4 = new Theater(4, "Cine World", 250, Arrays.asList("10:30 AM", "1:30 PM", "4:30 PM"), 3, Arrays.asList("2023-10-10", "2023-10-11", "2023-10-12"), "https://th.bing.com/th/id/OIP.yvn6mxHjKkSohMYnPCkPPAHaE4?w=128&h=104&c=7&bgcl=b61f8b&r=0&o=6&dpr=2&pid=13.1");
		theaterRepository.save(theater1);
		theaterRepository.save(theater2);
		theaterRepository.save(theater3);
		theaterRepository.save(theater4);
	}
}
