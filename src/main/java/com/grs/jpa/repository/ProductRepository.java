package com.grs.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grs.jpa.domain.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long>{

	
}
