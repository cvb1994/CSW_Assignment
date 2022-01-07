package t1911e.csw.movieService.demo.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ResponseDto {
	private String messsage;
	private List<MovieDto> trending;
	private List<MovieDto> top;
	
}
