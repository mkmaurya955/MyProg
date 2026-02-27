package com.example.onetomanymapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomanymapping.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{


}
