package com.project.shopapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopapp.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
