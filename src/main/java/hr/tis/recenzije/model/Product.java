package hr.tis.recenzije.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Check;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;

@Entity
@Check(constraints = "LENGTH(code) = 15")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, length = 15, nullable = false)
    @Pattern(message = "code mora imati točno 15 znakova", regexp = "[\\d]{15}")
	private String code;
	private String name;
    @Column(name = "price_eur")
	private Double priceEur;
    @Column(name = "price_usd")
	private Double priceUsd;
	private String description;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Review> reviews = new ArrayList<>();
	
	public Product() {}
	
	public Product(String code, String name, Double priceEur, Double priceUsd, String description) {
		this.code = code;
		this.name = name;
		this.priceEur = priceEur;
		this.priceUsd = priceUsd;
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPriceEur() {
		return priceEur;
	}
	
	public void setPriceEur(Double priceEur) {
		this.priceEur = priceEur;
	}
	
	public Double getPriceUsd() {
		return priceUsd;
	}
	
	public void setPriceUsd(Double priceUsd) {
		this.priceUsd = priceUsd;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Review> getReviews() {
		return reviews;
	}
}
