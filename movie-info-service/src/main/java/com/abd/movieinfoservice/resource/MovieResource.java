package com.abd.movieinfoservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abd.movieinfoservice.models.MovieInfo;

@RestController
@RequestMapping("/info")
public class MovieResource {
	
	@RequestMapping("/{movieId}")
	public MovieInfo getMovieInfo(@PathVariable("movieId") String movieID) {
		
		return new MovieInfo("1234", "Transformer", "Live action Sci-Fi from animation.");
	}

}
