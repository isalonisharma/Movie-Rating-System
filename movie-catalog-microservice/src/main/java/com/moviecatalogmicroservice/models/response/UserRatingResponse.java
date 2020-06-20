package com.moviecatalogmicroservice.models.response;

import java.util.List;

public class UserRatingResponse {
	private String userId;
	private List<RatingResponse> listRatingResponse;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<RatingResponse> getListRatingResponse() {
		return listRatingResponse;
	}

	public void setListRatingResponse(List<RatingResponse> listRatingResponse) {
		this.listRatingResponse = listRatingResponse;
	}
}
