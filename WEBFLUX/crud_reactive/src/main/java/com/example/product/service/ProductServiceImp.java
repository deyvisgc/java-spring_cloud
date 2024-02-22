package com.example.product.service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor // esto se usa para no usar el @Autowired
// webflux no utiliza list ni optional
/*
* Mono => devuelve 0 a 1 (aqui entraria un solo elemento)
* Flux => devuelve 0 a muchos (aqui entraria las listas)
*
* */
public class ProductServiceImp implements ProductService{
	private final ProductRepository productRepository;

	public Flux<Product> getAll() {
		return productRepository.findAll();
	}
	public Mono<Product> getById(int id) {
		return productRepository.findById(id);
	}
	public  Mono<Product> save(Product product) {
		return productRepository.save(product);
	}
	public Mono<Product> update(int id, Product product) {
		return productRepository.save(new Product(id, product.getName(), product.getPrice()));
	}
	public Mono<Void> delete(int id) {
		return  productRepository.deleteById(id);
	}
}
