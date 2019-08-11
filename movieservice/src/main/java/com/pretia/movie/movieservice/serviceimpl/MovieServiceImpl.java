package com.pretia.movie.movieservice.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pretia.movie.movieservice.enitity.Movie;
import com.pretia.movie.movieservice.repository.MovieRepository;
import com.pretia.movie.movieservice.service.MovieService;
import com.pretia.movie.movieservice.util.GenericServiceConstant;
/**
 * This Class defines methods to interact with Movie resources only.
 * @author Sougata Maitra
 * @version 1.0
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	
	@Autowired
	MovieRepository movieRepository;

	/**
	 * This method searches Movie data base and list all movie whose title contains a given string
	 * This method returns movies based on ascending order of movie names and paginate results based on
	 * number of records and page size.
	 */
	public Page<Movie> searchMovieByTitle(String title,int page) {
		int pageSize = GenericServiceConstant.PAGE_SIZE;
		Pageable pageable = PageRequest.of(page-1, pageSize,Sort.by("MOVIE_TITLE")); // Default Direction is ASCENDING 
		return movieRepository.findByTitleContaining(title, pageable);
	}

}
