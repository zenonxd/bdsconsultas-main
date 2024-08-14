package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MoviesMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MoviesMinProjection> list = movieRepository.search1("Action");

		List<MovieMinDTO> result = list.stream().map(
				x -> new MovieMinDTO(x)
		).collect(Collectors.toList());

		for (MovieMinDTO obj : result) {
			System.out.println(obj);
		}


		System.out.println("SECOND");
		List<MovieMinDTO> result2 = movieRepository.search2("Action");

		for (MovieMinDTO obj : result2) {
			System.out.println(obj);
		}
	}
}
