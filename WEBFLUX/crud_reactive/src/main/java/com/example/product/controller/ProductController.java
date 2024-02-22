package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
@Slf4j
//@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

	public final ProductServiceImp productService;

	@GetMapping
	public Flux<Product> getAll() {
		return productService.getAll();
	}
	@GetMapping("/{id}")
	public Mono<Product> getById(@PathVariable int id) {
		return productService.getById(id);
	}
	@PostMapping
	public Mono<Product> save(@RequestBody Product product) {
		return productService.save(product);
	}
	@PutMapping("/{id}")
	public Mono<Product> save(@PathVariable int id, @RequestBody Product product) {
		return productService.update(id, product);
	}
	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable int id) {
		return productService.delete(id);
	}
}
