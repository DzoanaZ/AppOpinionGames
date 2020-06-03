package pl.gamesrating.app.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private Double rating;
    private String comment;
    private LocalDateTime ratingDate;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;

    public enum Type{
        EDITORIAL, USER
    }

    public Rating() {
    }

    public Rating(Type type, Double rating, String comment, LocalDateTime ratingDate, Post post, User user) {
        this.type = type;
        this.rating = rating;
        this.comment = comment;
        this.ratingDate = ratingDate;
        this.post = post;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(LocalDateTime ratingDate) {
        this.ratingDate = ratingDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
