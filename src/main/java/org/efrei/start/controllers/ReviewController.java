package org.efrei.start.controllers;

import org.efrei.start.dto.CreateReview;
import org.efrei.start.models.Movie;
import org.efrei.start.models.Review;
import org.efrei.start.services.ReviewService;
import org.efrei.start.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService service;
    private final MovieService movieService;

    @Autowired
    public ReviewController(ReviewService service, MovieService movieService) {
        this.service = service;
        this.movieService = movieService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateReview createReview) {
        Review review = new Review();
        review.setComment(createReview.getComment());
        review.setStars(createReview.getStars());

        Movie movie = movieService.findById(createReview.getMovieId());
        if (movie != null) {
            review.setMovie(movie);
        }

        service.create(review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Review>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> findById(@PathVariable String id) {
        Review review = service.findById(id);
        if (review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody CreateReview updatedReview) {
        Review review = new Review();
        review.setComment(updatedReview.getComment());
        review.setStars(updatedReview.getStars());

        Movie movie = movieService.findById(updatedReview.getMovieId());
        if (movie != null) {
            review.setMovie(movie);
        }

        service.update(id, review);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
