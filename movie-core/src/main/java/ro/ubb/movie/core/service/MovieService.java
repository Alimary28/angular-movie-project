package ro.ubb.movie.core.service;

import ro.ubb.movie.core.model.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie updateMovie(Long id, String title, String category, String year, Double price);

    Movie addMovie(String title, String category, String year, double price);

    void delete(Long id);
}
