package com.example.hotel.hotelservice.service;

import java.util.List;

import com.example.hotel.hotelservice.entity.HotelDto;

public interface HotelService {
	
	HotelDto createHotel(HotelDto hotelDto);
	
	List<HotelDto> getAllHotel();
	
	HotelDto getByHotelId(Long hotelId);

}
