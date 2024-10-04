package org.efrei.start.services;

import org.efrei.start.models.Movie;
import org.efrei.start.models.Review;
import org.efrei.start.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repository;
    private final MovieService movieService;

    @Autowired
    public ReviewService(ReviewRepository repository, MovieService movieService) {
        this.repository = repository;
        this.movieService = movieService;
    }

    // READ ALL
    public List<Review> findAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Review findById(String id) {
        return repository.findById(id).orElse(null);
    }

    // CREATE : Accept Review instead of CreateReview
    public void create(Review review) {
        repository.save(review);
    }

    // UPDATE
    public void update(String id, Review updatedReview) {
        Review existingReview = findById(id);
        if (existingReview != null) {
            existingReview.setComment(updatedReview.getComment());
            existingReview.setStars(updatedReview.getStars());
            repository.save(existingReview);
        }
    }

    // DELETE
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
