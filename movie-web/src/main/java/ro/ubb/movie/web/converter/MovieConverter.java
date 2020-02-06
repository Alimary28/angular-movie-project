package ro.ubb.movie.web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ro.ubb.movie.core.model.Movie;
import ro.ubb.movie.web.dto.MovieDto;

@Component
public class MovieConverter extends BaseConverter<Movie, MovieDto> {

    @Override
    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = new Movie(dto.getTitle(), dto.getCategory(), dto.getYear(), dto.getPrice());
        movie.setId(dto.getId());
        return movie;
    }

    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto movieDto = new MovieDto(movie.getTitle(),
                movie.getCategory(), movie.getYear(), movie.getPrice());
        movieDto.setId(movie.getId());
        return movieDto;
    }
}
