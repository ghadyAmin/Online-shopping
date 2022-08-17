package com.UserLog.User.controller;


import com.UserLog.User.dto.ProductRequest;
import com.UserLog.User.entity.Product;
import com.UserLog.User.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path="/product/v1")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// Adding new product
	@PostMapping("/add")
	public String addProduct(@RequestBody ProductRequest product) {
	
			productService.addProduct(product);
			return "it is working";
	}
	
	// getting product by id
	@GetMapping(value= "/get/{id}")
	public Optional<Product> fetchProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	// getting all products
	@GetMapping("/get")
	public List<Product> fetchProductList() {
		return productService.getProductList();
	}
	
	// deleting product by id
	@DeleteMapping("/delete/{id}")

	public void deleteProductById(@PathVariable("id") Long id) {
		productService.deleteProductById(id);
		
	}
	

}
