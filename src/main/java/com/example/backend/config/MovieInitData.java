package com.example.backend.config;

import com.example.backend.model.Movie;
import com.example.backend.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieInitData implements CommandLineRunner {

    @Autowired
    IMovieRepository iMovieRepository;

    @Override
    public void run(String... args) throws Exception {
        if (iMovieRepository.count() == 0) { // Undgå at indsætte dubletter
            Movie movie1 = new Movie();
            movie1.setMovieName("Inception");
            movie1.setGenre("Sci-Fi");
            movie1.setAgeLimit(13);
            movie1.setDuration(148);

            Movie movie2 = new Movie();
            movie2.setMovieName("The Dark Knight");
            movie2.setGenre("Action");
            movie2.setAgeLimit(12);
            movie2.setDuration(152);

            Movie movie3 = new Movie();
            movie3.setMovieName("Titanic");
            movie3.setGenre("Romance");
            movie3.setAgeLimit(12);
            movie3.setDuration(195);

            iMovieRepository.save(movie1);
            iMovieRepository.save(movie2);
            iMovieRepository.save(movie3);

            System.out.println("Init data: 3 movies added!");
        }
    }
}
