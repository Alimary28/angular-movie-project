package ro.ubb.movie.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.movie.core.model.Movie;
import ro.ubb.movie.core.service.MovieService;
import ro.ubb.movie.web.converter.MovieConverter;
import ro.ubb.movie.web.dto.MovieDto;
import ro.ubb.movie.web.dto.MoviesDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class MovieController {
    public static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConverter movieConverter;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<MovieDto> getMovies() {
        log.trace("getMovies --- method entered");

        List<Movie> movies = movieService.getAllMovies();

        log.trace("getMovies={}", movies);

        return new ArrayList<>(movieConverter.convertModelsToDtos(movies));
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
   public MovieDto updateMovie(@PathVariable final Long id,
                         @RequestBody final MovieDto movieDto) {
        log.trace("updateMovie: id={}, movieDtoMap={}", id, movieDto);
        Movie movie = movieService.updateMovie(id, movieDto.getTitle(),
                movieDto.getCategory(), movieDto.getYear(), movieDto.getPrice());

        MovieDto result = movieConverter.convertModelToDto(movie);
        log.trace("updateMovie: result={}", result);
        return result;
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    public MovieDto addMovie(
            @RequestBody final MovieDto movieDto) {
        log.trace("addMovie: movieDto={}", movieDto);

        Movie movie = movieService.addMovie(movieDto.getTitle(), movieDto.getCategory(),
                movieDto.getYear(), movieDto.getPrice());

        MovieDto result = movieConverter.convertModelToDto(movie);

        log.trace("addMovie: result={}", result);

        return result;
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMovie(@PathVariable final Long id) {
        log.trace("deleteMovie: id={}", id);

        movieService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
