package hr.tis.recenzije.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.tis.recenzije.model.PopularProducts;
import hr.tis.recenzije.model.Product;
import hr.tis.recenzije.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
    
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@Valid @RequestBody final Product product) {
        if (product.getCode() == null || product.getName() == null || product.getPriceEur() == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts(@RequestParam(required = false) String code,
            										 @RequestParam(required = false) String name) {
        List<Product> products = productService.getProducts(code, name);
        return ResponseEntity.ok(products);
    }
    
    @GetMapping("/popular")
    public ResponseEntity<PopularProducts> getPopularProducts() {
        return ResponseEntity.ok(this.productService.getPopularProducts());
    }
    
}
