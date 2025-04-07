package hr.tis.recenzije.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import hr.tis.recenzije.ExchangeRateResponseObject;
import hr.tis.recenzije.ProductRepository;
import hr.tis.recenzije.model.PopularProducts;
import hr.tis.recenzije.model.PopularProductsDTO;
import hr.tis.recenzije.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${conversion.url.usd}")
    private String conversionUrlUsd;
    
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        if (product.getCode() == null || product.getName() == null || product.getPriceEur() == null) {
            return ResponseEntity.badRequest().build();
        }

        ExchangeRateResponseObject o = getExchangeRate();

        Double srednjiTecaj = Double.parseDouble(o.getSrednjiTecaj().replace(",", "."));
        
        product.setPriceUsd(product.getPriceEur()*srednjiTecaj);
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.ok(savedProduct);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts(@RequestBody Product product) {
    	
    	String code = product.getCode();
    	String name = product.getName();
    	
    	if(code != null && !code.isEmpty() && (name == null || name.isEmpty())) {
            return ResponseEntity.ok(productRepository.findByCode(code));
    	} else if (name != null && !name.isEmpty() && (code == null || code.isEmpty())) {
            return ResponseEntity.ok(productRepository.findByName(name));
    	} else if (name != null && !name.isEmpty() && code != null && !code.isEmpty()) {
            return ResponseEntity.ok(productRepository.findByCodeAndName(code, name));
    	} else {
            return ResponseEntity.ok(productRepository.findAll());
    	}
    }
    
    @GetMapping("/popular")
    public ResponseEntity<PopularProducts> getPopularProducts() {
    	List<PopularProductsDTO> popularProductsList = productRepository.findTopRatedProducts().stream().limit(3).collect(Collectors.toList());
        return ResponseEntity.ok(new PopularProducts(popularProductsList));
    }
    
    public ExchangeRateResponseObject getExchangeRate() {
        List<ExchangeRateResponseObject> exchangeRates = restTemplate.exchange(
        		conversionUrlUsd, 
                HttpMethod.GET, 
                null, 
                new ParameterizedTypeReference<List<ExchangeRateResponseObject>>() {}
            ).getBody();
        
        return exchangeRates.get(0);
    }
}
