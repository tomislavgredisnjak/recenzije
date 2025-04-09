package hr.tis.recenzije.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import hr.tis.recenzije.model.Product;
import hr.tis.recenzije.model.Review;
import hr.tis.recenzije.repository.ProductRepository;
import hr.tis.recenzije.repository.ReviewRepository;

@Component
public class Importer {

    public Importer(ProductRepository productRepository, ReviewRepository reviewRepository) {
        Product product = new Product("123456789012345", "Samsung Importer 2S", BigDecimal.valueOf(100.0), BigDecimal.valueOf(120.0), "Samsung Importer 2S mobitel");
        productRepository.save(product);

        List<Review> lista = new ArrayList<>();
        lista.add(new Review(product, "Jana", "Super!", 5));
        lista.add(new Review(product, "Helena", "Može proć!", 5));
        lista.add(new Review(product, "Vanja", "Vrlo vrlo dobar!", 4));
        reviewRepository.saveAll(lista);
    }
}
