package com.ratingdatamicroservice.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ratingdatamicroservice.models.responses.RatingDTO;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {

	private static final long serialVersionUID = 1648473125680448662L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "movie_id", nullable = false)
	private String movieId;
	
	@Column(name = "rating", nullable = false)
	private Integer rating;

	public Rating() {
		super();
	}

	public Rating(Long id, User user, String movieId, Integer rating) {
		super();
		this.id = id;
		this.user = user;
		this.movieId = movieId;
		this.rating = rating;
	}

	public Rating(RatingDTO ratingDTO,User user) {
		this.movieId = ratingDTO.getMovieId();
		this.rating = ratingDTO.getRating();
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", user=" + user + ", movieId=" + movieId + ", rating=" + rating + "]";
	}
}
