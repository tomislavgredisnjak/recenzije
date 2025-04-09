package hr.tis.recenzije.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Check;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Check(constraints = "LENGTH(code) = 15")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Column(unique = true, length = 15, nullable = false)
    @Pattern(message = "code mora imati točno 15 znakova", regexp = "^[A-Za-z0-9]{15}$")
	private String code;
	@NotEmpty
	@Column(nullable = false)
	private String name;
    @Positive
    @Column(name = "price_eur")
	private BigDecimal priceEur;
    @Positive
    @Column(name = "price_usd")
	private BigDecimal priceUsd;
	private String description;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Review> reviews = new ArrayList<>();
	
	public Product() {}
	
	public Product(String code, String name, BigDecimal priceEur, BigDecimal priceUsd, String description) {
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
	
	public BigDecimal getPriceEur() {
		return priceEur;
	}
	
	public void setPriceEur(BigDecimal priceEur) {
		this.priceEur = priceEur;
	}
	
	public BigDecimal getPriceUsd() {
		return priceUsd;
	}
	
	public void setPriceUsd(BigDecimal priceUsd) {
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
