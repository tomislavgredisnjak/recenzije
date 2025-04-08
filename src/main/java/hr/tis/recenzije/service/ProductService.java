package hr.tis.recenzije.service;

import java.util.List;

import hr.tis.recenzije.model.PopularProducts;
import hr.tis.recenzije.model.Product;

public interface ProductService {
	
	public PopularProducts getPopularProducts();
	
	public Product save(Product product);

	public List<Product> getProducts(String code, String name);
	
}
