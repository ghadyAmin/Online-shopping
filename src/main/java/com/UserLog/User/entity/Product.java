package com.UserLog.User.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
@Entity(name="productss")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String productName;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private double price;

    @Column(name="size")
    private String size;

    @Column(name = "photo")
    private String photo;




    public Product(String productName, String description, double price, String size, String photo) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.size = size;
        this.photo = photo;
    }






}

