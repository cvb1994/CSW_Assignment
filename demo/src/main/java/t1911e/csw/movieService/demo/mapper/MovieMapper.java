package t1911e.csw.movieService.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import t1911e.csw.movieService.demo.dto.CategoryDto;
import t1911e.csw.movieService.demo.dto.DirectorDto;
import t1911e.csw.movieService.demo.dto.MovieDto;
import t1911e.csw.movieService.demo.entity.Category;
import t1911e.csw.movieService.demo.entity.Director;
import t1911e.csw.movieService.demo.entity.Movie;

@Mapper(componentModel = "spring")
@Named("MovieMapper")
public interface MovieMapper {
	MovieDto entityToDto(Movie movie);
	Movie dtoToEntity(MovieDto movieDto);
	
	CategoryDto categoryToCategoryDto(Category category);
	DirectorDto directorToDirectorDto(Director director);
}
