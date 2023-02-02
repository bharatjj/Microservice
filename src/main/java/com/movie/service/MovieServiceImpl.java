package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entity.Movie;
import com.movie.entity.MovieDto;
import com.movie.repository.MovieRepository;



@Service
public class MovieServiceImpl implements MovieService {

	
	
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public MovieDto addMovie(MovieDto movieDto) {
		// TODO Auto-generated method stub
		
		Movie movie= new Movie();
		movie.setActor_actress(movieDto.getActor_actress());
		movie.setGenre(movieDto.getGenre());
		
		movie.setLanguage(movieDto.getLanguage());
		movie.setMovieName(movieDto.getMovieName());
		movie.setNames(movieDto.getNames());
		movie.setReleasedate(movieDto.getReleasedate());
		movie.setTags(movieDto.getReleasedate());
		movieRepository.save(movie);
		
		return movieDto;
	}

	@Override
	public MovieDto updateMoview(String id, MovieDto movieDto) {
		// TODO Auto-generated method stub
		
		Movie mval= movieRepository.findById(id).block();
		
		Movie movie= new Movie();
		
		movie.setActor_actress(movieDto.getActor_actress());
		movie.setGenre(movieDto.getGenre());
		
		movie.setLanguage(movieDto.getLanguage());
		movie.setMovieName(movieDto.getMovieName());
		movie.setNames(movieDto.getNames());
		movie.setReleasedate(movieDto.getReleasedate());
		movie.setTags(movieDto.getReleasedate());
		movie.setId(id);
		movieRepository.save(movie);
		
		return movieDto;
	}

	@Override
	public Movie getByMovieId(String id) {
		// TODO Auto-generated method stub
		return movieRepository.findById(id).block();
	}

	@Override
	public void deleteMovie(String id) {
		// TODO Auto-generated method stub
		movieRepository.deleteById(id);
	}

	@Override
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		return (List<Movie>) movieRepository.findAll();
	}

}
