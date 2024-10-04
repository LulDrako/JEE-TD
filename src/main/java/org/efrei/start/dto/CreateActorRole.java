package org.efrei.start.dto;

public class CreateActorRole {
    private String roleName;
    private boolean isMainRole;
    private String actorId;
    private String movieId;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isMainRole() {
        return isMainRole;
    }

    public void setMainRole(boolean isMainRole) {
        this.isMainRole = isMainRole;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
