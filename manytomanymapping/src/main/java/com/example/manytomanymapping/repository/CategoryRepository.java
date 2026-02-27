package com.example.manytomanymapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.manytomanymapping.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
