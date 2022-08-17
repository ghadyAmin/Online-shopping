package com.UserLog.User.service;

import com.UserLog.User.dto.ProductRequest;
import com.UserLog.User.entity.Product;
import com.UserLog.User.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public void addProduct(ProductRequest pt) {
		if ( pt != null) {

			Product p=new Product(pt.getName(),pt.getDesc(), pt.getPrice(), pt.getSize(), pt.getPhoto());
			productRepo.save(p);
		}

	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepo.findById(id);
	}

	@Override
	public List<Product> getProductList() {
		
		return productRepo.findAll();
	}

	@Override
	public void deleteProductById(Long id) {
		productRepo.deleteById(id);
		
	}

}
