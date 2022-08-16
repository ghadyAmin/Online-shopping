package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="products")
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

    //image
    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;




}
