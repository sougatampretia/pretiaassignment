package com.pretia.movie.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pretia.movie.movieservice.enitity.Movie;
import com.pretia.movie.movieservice.response.model.PageResponse;
import com.pretia.movie.movieservice.service.MovieService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class is responsible of exposing REST API for searching movie information by movie name.
 * @author Sougata Maitra
 * @version 1.0
 *
 */


@Api(value="This service exposes REST Service for  movie resource")

@RestController
@RequestMapping("/api")
public class MovieController {
	
	
	@Autowired
	MovieService movieService;
	
	@ApiOperation(value = "Retrievs paginated list of movies by movie title or partial title and page number . If no page number os given then default first page will be displayed along with it retunrs total records, total record in a page , current page number ", response = PageResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	
	/**
	 * This method provides REST interface for getting movie data from the database based on given title. 
	 * This method take two parameters 1. title or partial title of the movie and page number . Default page number is page 1 i.e first page,
	 * 
	 * @param title
	 * @param page
	 * @return
	 */
	@GetMapping(value="/movies/search",produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseStatus(HttpStatus.OK)
	
	public PageResponse<Movie> searchMovieByTitle (
	@ApiParam(name="Title", value = "Partial Name of the movie title", required = true)	
	@RequestParam("Title") String title,
	@ApiParam(value = "page number", defaultValue = "1",name="page")
	@RequestParam (defaultValue= "1",name="page") int page ) {
	
		PageResponse<Movie> pageResponse = new PageResponse<Movie> ();
		Page<Movie>  pageablemovies = movieService.searchMovieByTitle(title,page);
		pageResponse.setTotal(pageablemovies.getTotalElements());
		pageResponse.setTotal_pages(pageablemovies.getTotalPages());
		pageResponse.setData(pageablemovies.getContent());
		pageResponse.setPer_page(pageablemovies.getSize());
		pageResponse.setPage(page);
		return pageResponse;
	}
	
}
