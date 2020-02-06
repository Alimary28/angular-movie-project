package ro.ubb.movie.web.converter;

import ro.ubb.movie.core.model.BaseEntity;
import ro.ubb.movie.web.dto.BaseDto;

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);

}
