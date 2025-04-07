package hr.tis.recenzije.model;

public class PopularProductsDTO {
	
    private Product product;
    private double averageRating;

    public PopularProductsDTO(Product product, double averageRating) {
        this.product = product;
        this.averageRating = averageRating;
    }

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
}
