package t1911e.csw.movieService.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "director")
@Data
public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@OneToMany(mappedBy = "director")
	private List<Movie> listMovie;
}
