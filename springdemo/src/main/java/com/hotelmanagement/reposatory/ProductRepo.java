package com.hotelmanagement.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
