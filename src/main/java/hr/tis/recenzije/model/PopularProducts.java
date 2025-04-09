package hr.tis.recenzije.model;

import java.util.List;

import hr.tis.recenzije.model.dto.PopularProductsDTO;

public class PopularProducts {

    private List<PopularProductsDTO> popularProducts;

    public PopularProducts(List<PopularProductsDTO> popularProducts) {
        this.popularProducts = popularProducts;
    }

    public List<PopularProductsDTO> getPopularProducts() {
        return popularProducts;
    }

    public void setPopularProducts(List<PopularProductsDTO> popularProducts) {
        this.popularProducts = popularProducts;
    }
}
