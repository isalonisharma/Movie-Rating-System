package com.ratingdataservice.models;

public class Rating {
	private String id;
    private Integer rating;
	
    public Rating() {
		
	}

	public Rating(String id, Integer rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + "]";
	}
   
}
