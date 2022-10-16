package com.hotelmanagement.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
