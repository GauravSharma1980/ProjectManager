package com.grs.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grs.jpa.domain.Product;
import com.grs.jpa.repository.ProductRepository;




@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepsitory;
	
	
	public List<Product> listAll(){
		return productRepsitory.findAll();
	}
	
	
	public void save(Product product) {
	      productRepsitory.save(product);
	}
	
	public 	Product get(Long id) {
		return productRepsitory.getOne(id);
	}
	
	
	public void delete(Product product) {
		productRepsitory.delete(product);
	}
	
	public void delete(Long id) {
		productRepsitory.deleteById(id);
	}
}
