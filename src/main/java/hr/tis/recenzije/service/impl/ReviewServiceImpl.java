package hr.tis.recenzije.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.tis.recenzije.model.Review;
import hr.tis.recenzije.repository.ReviewRepository;
import hr.tis.recenzije.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private final ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public List<Review> findAll() {
		return reviewRepository.findAll();
	}
	
}
