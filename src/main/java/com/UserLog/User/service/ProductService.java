package com.UserLog.User.service;

import com.UserLog.User.dto.ProductRequest;
import com.UserLog.User.entity.Product;

import java.util.List;
import java.util.Optional;



public interface ProductService {

    // add product
    public void addProduct(ProductRequest product);

    // get product by id
    public Optional<Product> getProductById(Long id);

    //get all products
    public List<Product> getProductList();

    //delete product by id
    public void deleteProductById(Long id);

}