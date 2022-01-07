package t1911e.csw.movieService.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import t1911e.csw.movieService.demo.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{

}
