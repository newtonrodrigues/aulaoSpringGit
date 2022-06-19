package com.devsuperior.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	
	@Autowired
	private ProductRepository categoryRepository;
	
	
	public ProductResource(ProductRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = categoryRepository.findAll();
				
				
				/*new ArrayList<>();
		list.add(new Product(1L, "Eletronics"));
		list.add(new Product(2L, "Books"));*/
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
	
		Product cat = categoryRepository.findById(id).get();
				
				
				/*new Product(1L, "Eletronics");*/
		return ResponseEntity.ok().body(cat);
		
	}

}
