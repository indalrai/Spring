package com.hotelmanagement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelmanagement.model.Product;
import com.hotelmanagement.model.Visitor;
import com.hotelmanagement.reposatory.ProductRepo;
import com.hotelmanagement.reposatory.VisitorReposatory;

@SpringBootTest
class SpringdemoApplicationTests {

	@Autowired
	VisitorReposatory visitorReposatory;
	
	@Autowired
	ProductRepo productrepo;

	@Test
	public void testCreate() {
		Visitor visitor = new Visitor();
		Product product=new Product();
		product.setPid(1);
		product.setProductName("Sandwitch");
		product.setProductPrice(90);
		product.setNumberOfItems(12);
		List<Product> list=new ArrayList<Product>();
				list.add(product);
		
		visitor.setVid(1);
		visitor.setFirstName("Indal");
		visitor.setLastName("Rai");
		visitor.setProducts(null);
		visitor.setMobileNumber("9876543210");
		visitor.setEmailId("indal@gmail.com");
		visitorReposatory.save(visitor);
        assertNotNull(visitorReposatory.findById(1L).get());

	}

}
