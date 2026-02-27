package com.example.hotel.hotelservice.serviceimpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.hotelservice.entity.Hotel;
import com.example.hotel.hotelservice.entity.HotelDto;
import com.example.hotel.hotelservice.exception.ResourceNotFoundException;
import com.example.hotel.hotelservice.repository.HotelRepository;
import com.example.hotel.hotelservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public HotelDto createHotel(HotelDto hotelDto) {
		Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
		Hotel save = hotelRepository.save(hotel);
		return modelMapper.map(save, HotelDto.class);
	}

	@Override
	public List<HotelDto> getAllHotel() {
		List<Hotel> findAll = hotelRepository.findAll();
		return findAll.stream().map(e->modelMapper.map(e, HotelDto.class)).toList();
	}

	@Override
	public HotelDto getByHotelId(Long hotelId) {
		Hotel hotelById = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel is not Found..!!"));
		return modelMapper.map(hotelById, HotelDto.class);
	}

}
