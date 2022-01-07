package t1911e.csw.movieService.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
	private int id;
	private String name;
	private String thumbnail;
	private String description;
	private String duration;
	private CategoryDto category;
	private DirectorDto director;
	private MultipartFile file;
	private int categoryId;
	private int directorId;

}
