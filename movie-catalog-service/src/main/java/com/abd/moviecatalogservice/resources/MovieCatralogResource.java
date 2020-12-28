package com.abd.moviecatalogservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.abd.moviecatalogservice.models.CatalogItem;
import com.abd.moviecatalogservice.models.MovieInfo;
import com.abd.moviecatalogservice.models.UserRatings;

@RestController
@RequestMapping(value = "/catalog", produces = {"application/json"})
public class MovieCatralogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		UserRatings userRatings = restTemplate.getForObject("http://ratings-data-service/rating/user/" + userId, UserRatings.class);
	
//		List<RatingData> ratings = Arrays.asList(
//				new RatingData("1234", 4),
//				new RatingData("1235", 3),
//				new RatingData("1236", 5)
//			);
		
		return userRatings.getUserRatings().stream().map(rating -> {
			MovieInfo movie = restTemplate.getForObject("http://movie-info-service/info/" + rating.getMovieId(), MovieInfo.class);
			
//			MovieInfo movie = webClientBuilder.build()
//					.get()
//					.uri("http://localhost:8082/info/" + rating.getMovieId())
//					.retrieve()
//					.bodyToMono(MovieInfo.class)
//					.block();
			
			
			return new CatalogItem(rating.getMovieId(), movie.getName(), movie.getDesc(), rating.getRating());
		})
		.collect(Collectors.toList());
		
//		return Collections.singletonList(
//				new CatalogItem("Transformer", "Live action Sci-Fi from animation.", 4)
//			);
		
	}
}
