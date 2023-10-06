package com.sanskar.major.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sanskar.major.model.Product;
import com.sanskar.major.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
}
