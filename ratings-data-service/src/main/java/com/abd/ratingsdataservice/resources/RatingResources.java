package com.abd.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abd.ratingsdataservice.models.RatingData;
import com.abd.ratingsdataservice.models.UserRatings;

@RestController
@RequestMapping("/rating")
public class RatingResources {
	
	@RequestMapping("/{movieId}")
	public RatingData getRatingData(@PathVariable("movieId") String movieId) {
		return new RatingData("1234", 4);
	}
	
	@RequestMapping("user/{userId}")
	public UserRatings getRatingsData(@PathVariable("userId") String userId) {
		
		List<RatingData> ratings = Arrays.asList(
				new RatingData("234", 3),
				new RatingData("235", 4),
				new RatingData("236", 5)
			);
		
		UserRatings userRatings = new UserRatings();
		userRatings.setUserId(userId);
		userRatings.setUserRatings(ratings);
		
		return userRatings;
	}

}
