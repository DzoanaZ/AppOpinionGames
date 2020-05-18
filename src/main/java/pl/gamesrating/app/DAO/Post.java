package pl.gamesrating.app.DAO;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String title;
    private String description;
    private Double editorialRate;
    private Double usersRate;
    private LocalDate publicationDate;
    @ManyToOne
    private Category category;

    public Post() {
    }

    public Post(String title, String description, Double editorialRate, Double usersRate, LocalDate publicationDate, Category category) {
        this.title = title;
        this.description = description;
        this.editorialRate = editorialRate;
        this.usersRate = usersRate;
        this.publicationDate = publicationDate;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getEditorialRate() {
        return editorialRate;
    }

    public void setEditorialRate(Double editorialRate) {
        this.editorialRate = editorialRate;
    }

    public Double getUsersRate() {
        return usersRate;
    }

    public void setUsersRate(Double usersRate) {
        this.usersRate = usersRate;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
