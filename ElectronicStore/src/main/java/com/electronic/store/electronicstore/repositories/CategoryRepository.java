package com.electronic.store.electronicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electronic.store.electronicstore.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

}
