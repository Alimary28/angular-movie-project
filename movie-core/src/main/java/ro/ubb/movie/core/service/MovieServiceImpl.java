package ro.ubb.movie.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.movie.core.model.Movie;
import ro.ubb.movie.core.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    public static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public List<Movie> getAllMovies() {
        log.trace("getAllMovies --- method entered");

        List<Movie> result = movieRepository.findAll();

        log.trace("getAllMovies: result={}", result);

        return result;
    }

    @Override
    @Transactional
    public Movie updateMovie(Long id, String title, String category, String year, Double price) {

        log.trace("updateMovie: title={}, category={}, year={}, price={}", title, category, year, price);
        Optional<Movie> movie = movieRepository.findById(id);

        movie.ifPresent(m ->{
            m.setTitle(title);
            m.setCategory(category);
            m.setYear(year);
            m.setPrice(price);
        });

        log.trace("updateMovie: movie={}", movie.get());
        return movie.orElse(null);
    }

    @Override
    public Movie addMovie(String title, String category, String year, double price) {
        log.trace("addMovie: title={}, category={}, year={}, price={}", title, category, year, price);

        Movie movie = movieRepository.save(new Movie(title, category, year, price));

        log.trace("addMovie: movie={}", movie);
        return movie;
    }

    @Override
    public void delete(Long id) {
        log.trace("deleteMovie---method entered");

        movieRepository.deleteById(id);
        log.trace("deleteMovie=");
    }
}
