package pl.gamesrating.app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String title;
    @Column(length = 40000)
    private String description;
    private String shortDescription;
    private Double editorialRate;
    private Double usersRate;
    private LocalDate publicationDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private User author;

    private String imgPath;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Rating> ratings;

    public Post() {
    }

    public Post(String title, String description, String shortDescription, Double editorialRate, Double usersRate, LocalDate publicationDate, Category category, User author, String imgPath, List<Rating> ratings) {
        this.title = title;
        this.description = description;
        this.shortDescription = shortDescription;
        this.editorialRate = editorialRate;
        this.usersRate = usersRate;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
        this.imgPath = imgPath;
        this.ratings = ratings;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
