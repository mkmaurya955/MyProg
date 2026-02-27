package com.onetoone.mapping1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onetoone.mapping1.vo.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
