package com.example.hotel.hotelservice.controller;

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

import com.example.hotel.hotelservice.entity.HotelDto;
import com.example.hotel.hotelservice.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping("/createHotel")
	public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto) {
		HotelDto createHotel = hotelService.createHotel(hotelDto);
		return new ResponseEntity<>(createHotel, HttpStatus.CREATED);
	}

	@GetMapping("/getByHotelId")
	public ResponseEntity<HotelDto> getByHotelId(@RequestParam("hotelId") Long hotelId) {
		HotelDto getById = hotelService.getByHotelId(hotelId);
		return new ResponseEntity<>(getById, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<HotelDto>> GetAll() {
		List<HotelDto> getAll = hotelService.getAllHotel();
		return new ResponseEntity<>(getAll, HttpStatus.OK);
	}
}
