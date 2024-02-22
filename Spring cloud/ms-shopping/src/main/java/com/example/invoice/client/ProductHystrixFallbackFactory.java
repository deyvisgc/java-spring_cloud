package com.example.invoice.client;
import com.example.invoice.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

public class ProductHystrixFallbackFactory implements ProductClient{
	@Override
	public ResponseEntity<Product> getProduct(Long id) {
		Product product = Product.builder()
						.name("none")
						.price(0.00)
						.stock(0.00)
						.description("none")
						.status("no existe").build();
		return ResponseEntity.ok(product);
	}

	@Override
	public ResponseEntity<Product> updateStockProduct(Long id, Double quantity) {
		return null;
	}
}
