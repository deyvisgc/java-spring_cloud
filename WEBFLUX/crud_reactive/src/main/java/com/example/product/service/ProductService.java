package com.example.product.service;

import com.example.product.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

	public Flux<Product> getAll();
	public Mono<Product> getById(int id);
	public  Mono<Product> save(Product product);
	public Mono<Product> update(int id, Product product);
	public Mono<Void> delete(int id);
}
