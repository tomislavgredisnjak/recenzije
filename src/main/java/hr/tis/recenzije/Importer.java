package hr.tis.recenzije;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import hr.tis.recenzije.model.Product;
import hr.tis.recenzije.model.Review;

@Component
public class Importer {

    public Importer(ProductRepository productRepository, ReviewRepository reviewRepository) {
        Product product = new Product("123456789012345", "Test Product", 10.0, 12.0, "Test description");
        productRepository.save(product);

        List<Review> lista = new ArrayList<>();
        lista.add(new Review(product, "Jana", "Super!", 5));
        lista.add(new Review(product, "Helena", "Može proć!", 2));
        reviewRepository.saveAll(lista);
    }
}
