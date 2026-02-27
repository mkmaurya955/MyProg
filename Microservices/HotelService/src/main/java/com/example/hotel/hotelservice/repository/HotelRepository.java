package com.example.hotel.hotelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.hotelservice.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
