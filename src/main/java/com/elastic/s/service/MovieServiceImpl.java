package com.elastic.s.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elastic.s.entity.Movie;
import com.elastic.s.entity.MovieDto;
import com.elastic.s.repository.MovieElasticRepository;
import com.elastic.s.repository.MovieMongoRepository;



@Service
public class MovieServiceImpl implements MovieService {


	
	@Autowired
	MovieElasticRepository movieElasticRepository;
	
	@Autowired
	MovieMongoRepository movieMongoRepository;
	
	@Override
	public Iterable<Movie> addMovie(List<Movie> movieDto) {
		// TODO Auto-generated method stub
		
//		Movie movie= new Movie();
//		movie.setActor_actress(movieDto.getActor_actress());
//		movie.setGenre(movieDto.getGenre());
//		
//		movie.setLanguage(movieDto.getLanguage());
//		movie.setMovieName(movieDto.getMovieName());
//		movie.setNames(movieDto.getNames());
//		movie.setReleasedate(movieDto.getReleasedate());
//		movie.setTags(movieDto.getReleasedate());
		movieElasticRepository.saveAll(movieDto);
		
		return movieMongoRepository.saveAll(movieDto);
	}

	@Override
	public MovieDto updateMoview(String id, MovieDto movieDto) {
		// TODO Auto-generated method stub
		
		Movie mval= movieMongoRepository.findById(id).get();
		
		Movie movie= new Movie();
		
		movie.setActor_actress(movieDto.getActor_actress());
		movie.setGenre(movieDto.getGenre());
		
		movie.setLanguage(movieDto.getLanguage());
		movie.setMovieName(movieDto.getMovieName());
		movie.setNames(movieDto.getNames());
		movie.setReleasedate(movieDto.getReleasedate());
		movie.setTags(movieDto.getReleasedate());
		movie.setId(id);
		movieElasticRepository.save(movie);

		movieMongoRepository.save(movie);
		
		return movieDto;
	}
	
	 

	@Override
	public Optional<Movie> getByMovieId(String id) {
		// TODO Auto-generated method stub
		return movieElasticRepository.findById(id);
	}

	@Override
	public void deleteMovie(String id) {
		// TODO Auto-generated method stub
		movieMongoRepository.deleteById(id);
	}

	@Override
	public Iterable<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return  movieElasticRepository.findAll();
	}
	
	
	

}
