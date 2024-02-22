package com.example.product.handler;

import com.example.product.model.Product;
import com.example.product.service.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductHandler {
	private final ProductServiceImp productService;

	public Mono<ServerResponse> getAll(ServerRequest request) {
		Flux<Product> produscts = productService.getAll();
		return ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(produscts, Product.class);
	}
	public Mono<ServerResponse> getById(ServerRequest request) {
		int id = Integer.valueOf(request.pathVariable("id"));
		Mono<Product> product = productService.getById(id);
		return ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(product, Product.class);
	}
	public Mono<ServerResponse> save(ServerRequest request) {
		Mono<Product> product = request.bodyToMono(Product.class);
		return product.flatMap( p -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(productService.save(p), Product.class));
	}
	public Mono<ServerResponse> update (ServerRequest request) {
		int id = Integer.valueOf(request.pathVariable("id"));
		Mono<Product> product = request.bodyToMono(Product.class);
   	return product.flatMap(p -> ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
										.body(productService.update(id, p), Product.class)
		        );
	}

	public Mono<ServerResponse> delete (ServerRequest request) {
		int id = Integer.valueOf(request.pathVariable("id"));
		return ServerResponse.ok()
						.contentType(MediaType.APPLICATION_JSON)
						.body(productService.delete(id), Product.class);
	}

}
