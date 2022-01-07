package t1911e.csw.movieService.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import t1911e.csw.movieService.demo.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{
	@Query(value = "Select m.* From movie m Order By RAND() LIMIT 5", nativeQuery = true)
	List<Movie> findBYRandom();
}	
