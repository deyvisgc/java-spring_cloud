package com.example.product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.product.entity.Category;
import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import com.example.product.service.ProductServiceImpl;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock // Simula las operaciones que vas ha realizar
    private ProductRepository productRepository;

    private ProductService productService;

    // esto se ejecuta antes de iniciar las pruebas
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService =  new ProductServiceImpl( productRepository);
        Product computer =  Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();
        // es esta maqueando los metodos de abajo
        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(productRepository.save(computer)).thenReturn(computer);

    }

    @Test
   public void whenValidGetID_ThenReturnProduct(){
        Product found = productService.getProduct(1L);
        System.err.println(found.getName());
       Assertions.assertThat(found.getName()).isEqualTo("computer");

   }

   @Test
   public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = productService.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
   }
}
