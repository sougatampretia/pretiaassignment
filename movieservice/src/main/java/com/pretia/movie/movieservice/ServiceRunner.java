package com.pretia.movie.movieservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * This class is responsible for configuring spring boot environment and running embeded 
 * execution engine 
 * @author Sougata Maitra
 *
 */
@SpringBootApplication
public class ServiceRunner {
	/**
	 * This is the main method which is called once at the application loading time and responsible 
	 * for configuring spring boot environment.
	 * @param args
	 */
	public static void main(String [] args) {
		SpringApplication.run(ServiceRunner.class, args);
	}

}
