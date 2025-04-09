package hr.tis.recenzije.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hr.tis.recenzije.model.PopularProducts;
import hr.tis.recenzije.model.Product;
import hr.tis.recenzije.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
    @GetMapping("")
    public String getProducts(@RequestParam(required = false) String code,
            				  @RequestParam(required = false) String name, Model model) {
        List<Product> products = productService.getProducts(code, name);
        model.addAttribute("products", products);
        model.addAttribute("popularProducts", getPopularProducts());
        return "products";
    }
    
    public PopularProducts getPopularProducts() {
        return productService.getPopularProducts();
    }
    
}
