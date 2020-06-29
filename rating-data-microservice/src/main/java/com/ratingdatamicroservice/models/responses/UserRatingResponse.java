package com.ratingdatamicroservice.models.responses;

import java.util.Arrays;
import java.util.List;

public class UserRatingResponse {
	private String userId;
	private List<RatingResponse> listRatingResponse;

	public UserRatingResponse() {
		super();
	}

	public UserRatingResponse(String userId, List<RatingResponse> listRatingResponse) {
		super();
		this.userId = userId;
		this.listRatingResponse = listRatingResponse;
	}

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

	@Override
	public String toString() {
		return "UserRatingResponse [userId=" + userId + ", listRatingResponse=" + listRatingResponse + "]";
	}

	public void initData(String userId) {
		this.setUserId(userId);
		this.setListRatingResponse(Arrays.asList(new RatingResponse("550", 5), new RatingResponse("567", 4)));
	}
}