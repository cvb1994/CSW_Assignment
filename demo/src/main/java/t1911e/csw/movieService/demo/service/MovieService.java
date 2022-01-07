package t1911e.csw.movieService.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import t1911e.csw.movieService.demo.dto.MovieDto;
import t1911e.csw.movieService.demo.entity.Category;
import t1911e.csw.movieService.demo.entity.Director;
import t1911e.csw.movieService.demo.entity.Movie;
import t1911e.csw.movieService.demo.mapper.MovieMapper;
import t1911e.csw.movieService.demo.repository.CategoryRepository;
import t1911e.csw.movieService.demo.repository.DirectorRepository;
import t1911e.csw.movieService.demo.repository.MovieRepository;

@Service
public class MovieService {
	
	private static String rootPathImg = "E:\\Code\\Spring\\demo\\src\\main\\resources\\static\\img\\";
	private static String path = "http:/10.0.2.2:8081/img/";
	@Autowired
	private MovieRepository movieRepo;
	
	@Autowired
	private MovieMapper movieMapper;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private DirectorRepository directorRepo;
	
	public List<MovieDto> list(){
		List<MovieDto> list = movieRepo.findAll().stream().map(movieMapper::entityToDto).collect(Collectors.toList());
		List<MovieDto> newList = new ArrayList<MovieDto>();
		for(MovieDto m : list) {
			m.setThumbnail(path.concat(m.getThumbnail()));
			newList.add(m);
		}
		return newList;
	}
	
	public List<MovieDto> listRandom(){
		List<MovieDto> list = movieRepo.findBYRandom().stream().map(movieMapper::entityToDto).collect(Collectors.toList());
		List<MovieDto> newList = new ArrayList<MovieDto>();
		for(MovieDto m : list) {
			m.setThumbnail(path.concat(m.getThumbnail()));
			newList.add(m);
		}
		return newList;
	}
	
	public MovieDto save(MovieDto movieDto) throws IOException {
		Movie movie = Optional.ofNullable(movieDto).map(movieMapper::dtoToEntity).orElse(null);
		if(movie != null) {
			Optional<Category> optCategory = categoryRepo.findById(movieDto.getCategoryId());
			if(optCategory.isEmpty()) return null;
			Category category = optCategory.get();
			movie.setCategory(category);
			
			Optional<Director> optDirector = directorRepo.findById(movieDto.getDirectorId());
			if(optDirector.isEmpty()) return null;
			Director director = optDirector.get();
			movie.setDirector(director);
			
			byte[] bytes = movieDto.getFile().getBytes();
	        Path path = Paths.get(rootPathImg + movieDto.getFile().getOriginalFilename());
	        Files.write(path, bytes);
	        movie.setThumbnail(movieDto.getFile().getOriginalFilename());
			
			return Optional.ofNullable(movieRepo.save(movie)).map(movieMapper::entityToDto).orElse(null);
		}
		return null;
	}

}
