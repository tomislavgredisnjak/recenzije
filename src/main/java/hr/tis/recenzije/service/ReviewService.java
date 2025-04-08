package hr.tis.recenzije.service;

import hr.tis.recenzije.ReviewRepository;

public class ReviewService {

	private final ReviewRepository reviewRepository;

	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	
}
