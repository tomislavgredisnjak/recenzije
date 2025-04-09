package hr.tis.recenzije.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.tis.recenzije.model.Review;
import hr.tis.recenzije.service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
    @GetMapping("")
    public String getReviews(Model model) {
        List<Review> reviews = reviewService.findAll();
        model.addAttribute("reviews", reviews);
        return "reviews";
    }
	
}
