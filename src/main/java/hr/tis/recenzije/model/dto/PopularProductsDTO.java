package hr.tis.recenzije.model.dto;

import java.math.BigDecimal;

public class PopularProductsDTO {
	
    private String name;
    private BigDecimal averageRating;

    public PopularProductsDTO(String name, double averageRating) {
        this.name = name;
        this.averageRating = BigDecimal.valueOf(averageRating);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(BigDecimal averageRating) {
		this.averageRating = averageRating;
	}
}
