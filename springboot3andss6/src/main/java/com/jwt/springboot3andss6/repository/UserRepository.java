package com.jwt.springboot3andss6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.springboot3andss6.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long>{

	UserInfo getByUserName(String username);

}
