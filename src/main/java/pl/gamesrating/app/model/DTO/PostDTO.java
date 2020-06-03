package pl.gamesrating.app.model.DTO;

import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

public class PostDTO {
    private Long id;
    private String title;
    private String description;
    private String shortDescription;
    private Integer editorialRating;
    private Integer usersRating;
    private LocalDate publicationDate;
    private Long categoryId;
    private Long authorId;
    private MultipartFile image;

    public PostDTO() {
    }

    public PostDTO(Long id, String title, String description, String shortDescription, Integer editorialRating, Integer usersRating, LocalDate publicationDate, Long categoryId, Long authorId, MultipartFile image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.shortDescription = shortDescription;
        this.editorialRating = editorialRating;
        this.usersRating = usersRating;
        this.publicationDate = publicationDate;
        this.categoryId = categoryId;
        this.authorId = authorId;
        this.image = image;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getEditorialRating() {
        return editorialRating;
    }

    public void setEditorialRating(Integer editorialRating) {
        this.editorialRating = editorialRating;
    }

    public Integer getUsersRating() {
        return usersRating;
    }

    public void setUsersRating(Integer usersRating) {
        this.usersRating = usersRating;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
