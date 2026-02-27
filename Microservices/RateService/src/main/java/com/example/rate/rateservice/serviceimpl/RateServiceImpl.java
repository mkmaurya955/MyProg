package com.example.rate.rateservice.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rate.rateservice.dto.RatingDto;
import com.example.rate.rateservice.entity.Rating;
import com.example.rate.rateservice.exception.ResourceNotFoundException;
import com.example.rate.rateservice.repository.RateRepository;
import com.example.rate.rateservice.service.RateService;

@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RateRepository rateRepository;

	@Override
	public RatingDto createRating(RatingDto ratingDto) {
		Rating rating = modelMapper.map(ratingDto, Rating.class);
		Rating saveRating = rateRepository.save(rating);
		return modelMapper.map(saveRating, RatingDto.class);
	}

	@Override
	public RatingDto getByRatingId(Long ratingId) {
		Rating elseThrow = rateRepository.findById(ratingId)
				.orElseThrow(() -> new ResourceNotFoundException("Rating is not Present !!"));
		return modelMapper.map(elseThrow, RatingDto.class);
	}

	@Override
	public List<RatingDto> getAllRatingDto() {
		List<Rating> findAll = rateRepository.findAll();
		return findAll.stream().map(e -> modelMapper.map(e, RatingDto.class)).toList();

	}

	@Override
	public RatingDto getByHotelId(String hotelId) {
		Rating findByHotelId = rateRepository.findByHotelId(hotelId);
		return modelMapper.map(findByHotelId, RatingDto.class);
	}

	@Override
	public List<RatingDto> getByUserId(String userid) {
		List<Rating> findByUserId = rateRepository.findByUserId(userid);
		return findByUserId.stream().map(e -> modelMapper.map(e, RatingDto.class)).toList();
	}

}
