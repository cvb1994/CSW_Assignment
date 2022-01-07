package t1911e.csw.movieService.demo.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDto {
	private int id;
	private String name;
	private String image;
	private String description;

}
