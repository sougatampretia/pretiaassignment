package com.pretia.movie.movieservice.service;

import org.springframework.data.domain.Page;

import com.pretia.movie.movieservice.enitity.Movie;

/**
 * This is the interface for Service class.
 * This method declares methods available in service class implementations.
 *  
 * @author Sougata Maitra
 * @version 1.0
 */
public interface MovieService {
	
	/**
	 * This is the method definition for search movie by titile finctionality
	 * @param title
	 * @param page
	 * @return 
	 */
	Page<Movie> searchMovieByTitle(String title,int page);

}
