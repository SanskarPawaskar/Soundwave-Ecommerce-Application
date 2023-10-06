package com.sanskar.major.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanskar.major.model.Category;
import com.sanskar.major.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		categoryRepository.save(category);

	}

	public List<Category> getAllCategroy() {
		return categoryRepository.findAll();
	}
	
	public void removeCategoryById(int id) {
		categoryRepository.deleteById(id);
	}
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);
	}
}
