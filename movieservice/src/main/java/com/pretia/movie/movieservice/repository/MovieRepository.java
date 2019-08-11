package com.pretia.movie.movieservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pretia.movie.movieservice.enitity.Movie;

/**
 * This is spring repository . This provides repository interaction interfaces to store and fetch 
 * repository resources.
 * @author Sougata Maitra
 * @version 1.0
 */

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer>{
	
	/**
	 * This repository method returns  all movies which contains specific 
	 * @param title
	 * @param pageable
	 * @return
	 */
	@Query(value = "select * from IMBD_MOVIE_TAB mov where mov.MOVIE_TITLE like %?1%", nativeQuery = true)
	Page<Movie> findByTitleContaining(String title, Pageable pageable);

}
