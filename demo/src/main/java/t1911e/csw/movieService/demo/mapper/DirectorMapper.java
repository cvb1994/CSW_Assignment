package t1911e.csw.movieService.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import t1911e.csw.movieService.demo.dto.DirectorDto;
import t1911e.csw.movieService.demo.entity.Director;


@Mapper(componentModel = "spring")
@Named("DirectorMapper")
public interface DirectorMapper {
	DirectorDto entityToDto(Director director);
	Director dtoToEntity(DirectorDto directorDto);
}
