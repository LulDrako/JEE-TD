package org.efrei.start.services;

import org.efrei.start.dto.CreateActorRole;
import org.efrei.start.models.Actor;
import org.efrei.start.models.ActorRole;
import org.efrei.start.models.Movie;
import org.efrei.start.repositories.ActorRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorRoleService {

    private final ActorRoleRepository repository;
    private final ActorService actorService;
    private final MovieService movieService;

    @Autowired
    public ActorRoleService(ActorRoleRepository repository, ActorService actorService, MovieService movieService) {
        this.repository = repository;
        this.actorService = actorService;
        this.movieService = movieService;
    }

    public List<ActorRole> findAll() {
        return repository.findAll();
    }

    public ActorRole findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void create(CreateActorRole createActorRole) {
        ActorRole actorRole = new ActorRole();
        actorRole.setRoleName(createActorRole.getRoleName());
        actorRole.setMainRole(createActorRole.isMainRole());

        Actor actor = actorService.findById(createActorRole.getActorId());
        Movie movie = movieService.findById(createActorRole.getMovieId());

        if (actor != null) {
            actorRole.setActor(actor);
        }
        if (movie != null) {
            actorRole.setMovie(movie);
        }

        repository.save(actorRole);
    }

    public void update(String id, CreateActorRole updatedRole) {
        ActorRole existingRole = findById(id);
        if (existingRole != null) {
            existingRole.setRoleName(updatedRole.getRoleName());
            existingRole.setMainRole(updatedRole.isMainRole());

            Actor actor = actorService.findById(updatedRole.getActorId());
            Movie movie = movieService.findById(updatedRole.getMovieId());

            if (actor != null) {
                existingRole.setActor(actor);
            }
            if (movie != null) {
                existingRole.setMovie(movie);
            }

            repository.save(existingRole);
        }
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
