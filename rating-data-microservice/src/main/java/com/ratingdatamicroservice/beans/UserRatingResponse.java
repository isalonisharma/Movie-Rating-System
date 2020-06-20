package com.ratingdatamicroservice.beans;

import java.util.Arrays;
import java.util.List;

public class UserRatingResponse {
	private String userId;
	private List<RatingResponse> ratingResponseBean;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<RatingResponse> getRatingResponseBean() {
		return ratingResponseBean;
	}

	public void setRatingResponseBean(List<RatingResponse> ratingResponseBean) {
		this.ratingResponseBean = ratingResponseBean;
	}

	public void initData(String userId) {
		this.setUserId(userId);
		this.setRatingResponseBean(Arrays.asList(new RatingResponse("550", 5), new RatingResponse("567", 4)));
	}
}
