package t1911e.csw.movieService.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

import t1911e.csw.movieService.demo.dto.CategoryDto;
import t1911e.csw.movieService.demo.entity.Category;

@Mapper(componentModel = "spring")
@Named("CategoryMapper")
public interface CategoryMapper {
	CategoryDto entityToDto(Category category);
	Category dtoToEntity(CategoryDto categoryDto);
}
