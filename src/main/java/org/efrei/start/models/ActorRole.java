package org.efrei.start.models;

import jakarta.persistence.*;

@Entity
public class ActorRole {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String roleName;  // Nom du rôle joué par l'acteur

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;  // L'acteur qui joue le rôle

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;  // Le film dans lequel le rôle est joué

    @Column(nullable = false)
    private boolean isMainRole;  // Indique si c'est un rôle principal ou non

    public ActorRole() {}

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public boolean isMainRole() {
        return isMainRole;
    }

    public void setMainRole(boolean mainRole) {
        isMainRole = mainRole;
    }
}
