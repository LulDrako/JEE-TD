package org.efrei.start.services;

import org.efrei.start.dto.CreateMovie;
import org.efrei.start.models.Movie;
import org.efrei.start.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Movie findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void create(CreateMovie createMovie) {
        Movie movie = new Movie();
        movie.setTitle(createMovie.getTitle());
        movie.setResume(createMovie.getResume());
        movie.setPersonnage(createMovie.getPersonnage());
        movie.setCategory(createMovie.getCategory());
        repository.save(movie);
    }

    public void update(String id, Movie movie) {
        Movie existingMovie = findById(id);
        if (existingMovie != null) {
            existingMovie.setTitle(movie.getTitle());
            existingMovie.setResume(movie.getResume());
            existingMovie.setPersonnage(movie.getPersonnage());
            existingMovie.setCategory(movie.getCategory());
            repository.save(existingMovie);
        }
    }

}
