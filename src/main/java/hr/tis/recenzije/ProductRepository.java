package hr.tis.recenzije;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hr.tis.recenzije.model.PopularProductsDTO;
import hr.tis.recenzije.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE " +
            "(LOWER(p.code) LIKE LOWER(CONCAT('%', :code, '%'))) AND " +
            "(LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))")
	public List<Product> findByCodeAndName(String code, String name);
	
	@Query("SELECT p FROM Product p WHERE " +
            "(LOWER(p.code) LIKE LOWER(CONCAT('%', :code, '%')))")
	public List<Product> findByCode(String code);
	
	@Query("SELECT p FROM Product p WHERE " +
            "(LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))")
	public List<Product> findByName(String name);
	
	@Query("SELECT new hr.tis.recenzije.model.PopularProductsDTO(r.product, AVG(r.rating) as average_rating) FROM Review r GROUP BY r.product.id, r.product.code, r.product.name ORDER BY average_rating DESC")
	public List<PopularProductsDTO> findTopRatedProducts();
}