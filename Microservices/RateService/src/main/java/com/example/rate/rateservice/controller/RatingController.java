package com.example.rate.rateservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rate.rateservice.dto.RatingDto;
import com.example.rate.rateservice.service.RateService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RateService rateService;

	@PostMapping("/createRating")
	public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) {
		RatingDto createRating = rateService.createRating(ratingDto);
		return new ResponseEntity<>(createRating, HttpStatus.CREATED);

	}

	@GetMapping("/getRating")
	public ResponseEntity<RatingDto> getRating(@RequestParam("rateId") Long rateId) {
		RatingDto getById = rateService.getByRatingId(rateId);
		return new ResponseEntity<>(getById, HttpStatus.OK);

	}

	@PostMapping("/getAllRating")
	public ResponseEntity<List<RatingDto>> getAllRating() {
		List<RatingDto> getAll = rateService.getAllRatingDto();
		return new ResponseEntity<>(getAll, HttpStatus.OK);

	}

	@PostMapping("/getByUserId")
	public ResponseEntity<List<RatingDto>> getRatingByUserId(@RequestParam("userId") String userId) {
		List<RatingDto> getByUserId = rateService.getByUserId(userId);
		return new ResponseEntity<>(getByUserId, HttpStatus.OK);

	}

	@PostMapping("/getByHotelId")
	public ResponseEntity<RatingDto> getByHotelId(@RequestParam("hotelId") String hotelId) {
		RatingDto getByHotelId = rateService.getByHotelId(hotelId);
		return new ResponseEntity<>(getByHotelId, HttpStatus.OK);

	}

}
