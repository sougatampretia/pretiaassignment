package com.pretia.movie.movieservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.pretia.movie.movieservice.enitity.Movie;
import com.pretia.movie.movieservice.response.model.PageResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceRunner.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class APITest {
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	} 
	@LocalServerPort
	private int port;
	HttpHeaders headers = new HttpHeaders();

	TestRestTemplate restTemplate = new TestRestTemplate();
	
	@Test 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getMovieWithoutPageNumber() {
		HttpEntity entity = new HttpEntity (headers);
		ResponseEntity <PageResponse<Movie>> response = restTemplate.exchange(createURLWithPort("/api/movies/search/?Title=spiderman&page=2"),
				HttpMethod.GET, entity,new ParameterizedTypeReference<PageResponse<Movie>>() {});
		System.out.println(response.getBody());
		PageResponse<Movie> pageResponse =  response.getBody();
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(2, pageResponse.getTotal_pages());
		assertEquals(20,pageResponse.getTotal());
		List<Movie> movieList = pageResponse.getData();
		assertNotNull(movieList);
		
		
	}
	
	@Test 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getMovieWitPageNumber() {
		HttpEntity entity = new HttpEntity (headers);
		ResponseEntity <PageResponse<Movie>> response = restTemplate.exchange(createURLWithPort("/api/movies/search/?Title=spiderman&page=2"),
				HttpMethod.GET, entity,new ParameterizedTypeReference<PageResponse<Movie>>() {});
		System.out.println(response.getBody());
		assertEquals(200, response.getStatusCodeValue());
		List<Movie> movieList = response.getBody().getData();
		assertNotNull(movieList);
		
		
		
	}
	
	@Test 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getMovieWithoutPageNumberAndWrongName() {
		HttpEntity entity = new HttpEntity (headers);
		ResponseEntity <PageResponse<Movie>> response = restTemplate.exchange(createURLWithPort("/api/movies/search/?Title=spmovie&page=2"),
				HttpMethod.GET, entity,new ParameterizedTypeReference<PageResponse<Movie>>() {});
		System.out.println(response.getBody());
		PageResponse<Movie> pageResponse = response.getBody();
		assertEquals(200, response.getStatusCodeValue());
		assertEquals(0,pageResponse.getTotal());
		
	}

}
