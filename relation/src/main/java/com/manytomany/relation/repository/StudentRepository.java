package com.manytomany.relation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manytomany.relation.vo.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
