package com.example.rate.rateservice.service;

import java.util.List;

import com.example.rate.rateservice.dto.RatingDto;

public interface RateService {

	RatingDto createRating(RatingDto ratingDto);

	RatingDto getByRatingId(Long ratingId);

	List<RatingDto> getAllRatingDto();

	RatingDto getByHotelId(String hotelId);

	List<RatingDto> getByUserId(String userid);

}
