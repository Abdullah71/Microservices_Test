package com.abd.moviecatalogservice.models;

import java.util.List;

public class UserRatings {

	private String UserId;
	private List<RatingData> userRatings;
	
	
	public UserRatings() {
		
	}
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	
	public List<RatingData> getUserRatings() {
		return userRatings;
	}
	public void setUserRatings(List<RatingData> userRatings) {
		this.userRatings = userRatings;
	}
	
	
	
	
}
