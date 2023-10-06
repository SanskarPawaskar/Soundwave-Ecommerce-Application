package com.sanskar.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanskar.major.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
