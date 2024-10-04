package org.efrei.start.models;
import jakarta.persistence.*;
import org.efrei.start.global.Category;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "resume", length = 1000)
    private String resume;

    @Column(name = "personnage", length = 200)
    private String personnage;

    @Enumerated(EnumType.STRING)
    private Category category;

    public Movie(String title, String resume, String personnage, Category category) {
        this.title = title;
        this.resume = resume;
        this.personnage = personnage;
        this.category = category;
    }

    public Movie() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
