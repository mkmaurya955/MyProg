package com.example.rate.rateservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "RATING")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingId;

	private String userId;

	private String hotelId;

	private String ratings;

	private String feedback;

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", userId=" + userId + ", hotelId=" + hotelId + ", ratings=" + ratings
				+ ", feedback=" + feedback + "]";
	}

	public Rating(Long ratingId, String userId, String hotelId, String ratings, String feedback) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.ratings = ratings;
		this.feedback = feedback;
	}

	public Rating() {
		super();
	}

}
