package com.UserLog.User.repository;


import com.UserLog.User.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    public Optional<Product> findByProductName(String name);
    public Optional<Product> findById(Long Id);


}
