package com.sanskar.major.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sanskar.major.dto.ProductDTO;
import com.sanskar.major.model.Category;
import com.sanskar.major.repository.CategoryRepository;
import com.sanskar.major.service.CategoryService;
import com.sanskar.major.service.ProductService;

@Controller
public class AdminController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/admin")
	public String adminHome() {
		return "adminhome";
	}
	
	@GetMapping("/admin/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryService.getAllCategroy());
		return "categories";
	}

	@GetMapping("/admin/categories/add")
	public String getAddCategories(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postAddCategories(@ModelAttribute("category")Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id){
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}
	@GetMapping("/admin/categories/update/{id}")
	public String updateCategory(@PathVariable int id,Model model){
		Optional<Category> cateogty = categoryService.getCategoryById(id);
		if(cateogty.isPresent()) {
			model.addAttribute("category", cateogty.get());
			return "categoriesAdd";
		}else {
			return "404";
		}
	}
	
	//Product Controllers
	
	@GetMapping("/admin/products")
	public String getProducts(Model model){
		model.addAttribute("products", productService.getAllProduct()); 	
		return "products";
	}
	
	@GetMapping("/admin/products/add")
	public String getAddProducts(Model model){
		model.addAttribute("productDTO", new ProductDTO());
		return "productsAdd";
	}
	
	@PostMapping
	public String postAddProducts(Model model){
		model.addAttribute("productDTO", new ProductDTO());
		return "products";
	}
	
	
	
	
}
