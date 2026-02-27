package com.example.rate.rateservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rate.rateservice.entity.Rating;

@Repository
public interface RateRepository extends JpaRepository<Rating, Long>{

	Rating findByHotelId(String hotelId);

	List<Rating> findByUserId(String userid);

}
