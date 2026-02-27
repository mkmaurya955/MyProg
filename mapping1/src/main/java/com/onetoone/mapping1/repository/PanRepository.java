package com.onetoone.mapping1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetoone.mapping1.vo.Pan;

@Repository
public interface PanRepository extends JpaRepository<Pan, Long>{

}
