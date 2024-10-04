package org.efrei.start.dto;

public class CreateReview {

    private String comment;
    private int stars;  // Les étoiles (note du film)
    private String movieId;

    // Getters et Setters
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
