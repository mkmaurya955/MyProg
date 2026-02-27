package com.electronic.store.electronicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electronic.store.electronicstore.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

	Users findByName(String userName);

}
