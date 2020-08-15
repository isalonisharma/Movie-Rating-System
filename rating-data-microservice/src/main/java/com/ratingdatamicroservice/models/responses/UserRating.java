package com.ratingdatamicroservice.models.responses;

import java.util.List;

public class UserRating {
	private Long userId;
	private List<RatingDTO> listRatingDTO;

	public UserRating() {
		super();
	}

	public UserRating(Long userId, List<RatingDTO> listRatingDTO) {
		super();
		this.userId = userId;
		this.listRatingDTO = listRatingDTO;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<RatingDTO> getListRatingDTO() {
		return listRatingDTO;
	}

	public void setListRatingDTO(List<RatingDTO> listRatingDTO) {
		this.listRatingDTO = listRatingDTO;
	}

	@Override
	public String toString() {
		return "UserRating [userId=" + userId + ", listRatingDTO=" + listRatingDTO + "]";
	}
}