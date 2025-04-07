package hr.tis.recenzije;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.tis.recenzije.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}