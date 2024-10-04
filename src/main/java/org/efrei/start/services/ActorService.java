package org.efrei.start.services;

import org.efrei.start.dto.CreateActor;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Movie;
import org.efrei.start.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository repository;
    private final MovieService movieService;

    @Autowired
    public ActorService(ActorRepository repository, MovieService movieService) {
        this.repository = repository;
        this.movieService = movieService;
    }

    public List<Actor> findAll() {
        return repository.findAll();
    }

    public void create(CreateActor createActor) {
        Actor actor = new Actor();
        actor.setFirstname(createActor.getFirstName());
        actor.setName(createActor.getName());

        Movie movie = movieService.findById(createActor.getMovieId());
        if (movie != null) {
            actor.setMovie(movie);
        }

        repository.save(actor);
    }

    public Actor findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public void update(String id, Actor actor) {
        Actor updatedActor = findById(id);
        if (updatedActor != null) {
            updatedActor.setName(actor.getName());
            updatedActor.setFirstname(actor.getFirstname());
            repository.save(updatedActor);
        }
    }
}
