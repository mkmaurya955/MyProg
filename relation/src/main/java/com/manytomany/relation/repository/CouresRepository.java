package com.manytomany.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manytomany.relation.vo.Courses;

@Repository
public interface CouresRepository extends JpaRepository<Courses, Long>{

}
