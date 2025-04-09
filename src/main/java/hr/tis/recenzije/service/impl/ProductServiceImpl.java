package hr.tis.recenzije.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hr.tis.recenzije.mapper.ExchangeRateResponseObject;
import hr.tis.recenzije.model.PopularProducts;
import hr.tis.recenzije.model.Product;
import hr.tis.recenzije.model.dto.PopularProductsDTO;
import hr.tis.recenzije.repository.ProductRepository;
import hr.tis.recenzije.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${conversion.url.usd}")
    private String conversionUrlUsd;
	
	private final ProductRepository productRepository;
    private final RestTemplate restTemplate;
	
	public ProductServiceImpl(ProductRepository productRepository, RestTemplate restTemplate) {
		this.productRepository = productRepository;
		this.restTemplate = restTemplate;
	}
	
	public PopularProducts getPopularProducts() {
		List<PopularProductsDTO> topThreePopularProductsList = productRepository.findTopRatedProducts().stream().map(pp -> {
	        pp.setAverageRating(pp.getAverageRating().setScale(1, RoundingMode.HALF_UP));
	        return pp;
	    }).limit(3).collect(Collectors.toList());
		return new PopularProducts(topThreePopularProductsList);
	}
	
	public Product save(Product product) {
		if(product.getPriceEur() != null) {
	        ExchangeRateResponseObject exchangeRate = getExchangeRate();
	        Double srednjiTecaj = Double.parseDouble(exchangeRate.getSrednjiTecaj().replace(",", "."));
	        product.setPriceUsd(BigDecimal.valueOf(product.getPriceEur().doubleValue()*srednjiTecaj).setScale(2, RoundingMode.HALF_UP));
		}

        return productRepository.save(product);
	}
	
	public List<Product> getProducts(String code, String name) {
		if (name != null && !name.isEmpty() && code != null && !code.isEmpty()) {
            return productRepository.findByCodeAndName(code, name);
    	} else if(code != null && !code.isEmpty()) {
            return productRepository.findByCode(code);
    	} else if (name != null && !name.isEmpty()) {
            return productRepository.findByName(name);
    	}
		
        return productRepository.findAll();
	}
	
	public List<Product> findAll() {
        return productRepository.findAll();
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
