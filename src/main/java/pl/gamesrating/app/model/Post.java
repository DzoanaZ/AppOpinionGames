package pl.gamesrating.app.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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


    public List<Rating> getUsersRatings() {
        List<Rating> usersRatings = new ArrayList<>();
        for (Rating tmp : this.ratings) {
            if(!tmp.isEditorialRating()) {
                usersRatings.add(tmp);
            }
        }
        return usersRatings;
    }

    public List<Rating> getEditorialsRatings() {
        List<Rating> editorialsRatings = new ArrayList<>();
        for (Rating tmp : this.ratings) {
            if(tmp.isEditorialRating()) {
                editorialsRatings.add(tmp);
            }
        }
        return editorialsRatings;
    }

    public int count5EditorialValues() {
        return countRatingValue(5.0, Rating.Type.EDITORIAL);
    }
    public int count4EditorialValues() {
        return countRatingValue(4.0, Rating.Type.EDITORIAL);
    }
    public int count3EditorialValues() {
        return countRatingValue(3.0, Rating.Type.EDITORIAL);
    }
    public int count2EditorialValues() {
        return countRatingValue(2.0, Rating.Type.EDITORIAL);
    }
    public int count1EditorialValues() {
        return countRatingValue(1.0, Rating.Type.EDITORIAL);
    }
    public int countEditorialValues() {
        return countAllRatingValue(Rating.Type.EDITORIAL);
    }

    public int count5UsersValues() {
        return countRatingValue(5.0, Rating.Type.USER);
    }
    public int count4UsersValues() {
        return countRatingValue(4.0, Rating.Type.USER);
    }
    public int count3UsersValues() {
        return countRatingValue(3.0, Rating.Type.USER);
    }
    public int count2UsersValues() {
        return countRatingValue(2.0, Rating.Type.USER);
    }
    public int count1UsersValues() {
        return countRatingValue(1.0, Rating.Type.USER);
    }
    public int countUsersValues() {
        return countAllRatingValue(Rating.Type.USER);
    }

    public double percentOf5UsersValues() {
        return  100.0 * (double)count5UsersValues() / (double)countAllRatingValue(Rating.Type.USER);
    }
    public double percentOf4UsersValues() {
        return  100.0 * (double)count4UsersValues() / (double)countAllRatingValue(Rating.Type.USER);
    }
    public double percentOf3UsersValues() {
        return  100.0 * (double)count3UsersValues() / (double)countAllRatingValue(Rating.Type.USER);
    }
    public double percentOf2UsersValues() {
        return  100.0 * (double)count2UsersValues() / (double)countAllRatingValue(Rating.Type.USER);
    }
    public double percentOf1UsersValues() {
        return  100.0 * (double)count1UsersValues() / (double)countAllRatingValue(Rating.Type.USER);
    }

    public double percentOf5EditoralsValues() {
        return  100.0 * (double)count5EditorialValues() / (double)countAllRatingValue(Rating.Type.EDITORIAL);
    }
    public double percentOf4EditoralsValues() {
        return  100.0 * (double)count4EditorialValues() / (double)countAllRatingValue(Rating.Type.EDITORIAL);
    }
    public double percentOf3EditoralsValues() {
        return  100.0 * (double)count3EditorialValues() / (double)countAllRatingValue(Rating.Type.EDITORIAL);
    }
    public double percentOf2EditoralsValues() {
        return  100.0 * (double)count2EditorialValues() / (double)countAllRatingValue(Rating.Type.EDITORIAL);
    }
    public double percentOf1EditoralsValues() {
        return  100.0 * (double)count1EditorialValues() / (double)countAllRatingValue(Rating.Type.EDITORIAL);
    }
    public int countRatingValue(Double value, Rating.Type type) {
        List<Rating> listRating = new ArrayList<>();
        switch (type) {
            case EDITORIAL:
                for(Rating tmp : getEditorialsRatings()) {
                    if(tmp.getRating().doubleValue() == value.doubleValue())
                        listRating.add(tmp);
                }
                break;
            case USER:
                for(Rating tmp : getUsersRatings()) {
                    if(tmp.getRating().doubleValue()  == value.doubleValue())
                        listRating.add(tmp);
                }
                break;
        }
        return listRating.size();
    }

    public int countAllRatingValue(Rating.Type type) {
        List<Rating> listRating = new ArrayList<>();
        switch (type) {
            case EDITORIAL:
                for(Rating tmp : getEditorialsRatings()) {
                    listRating.add(tmp);
                }
                break;
            case USER:
                for(Rating tmp : getUsersRatings()) {
                    listRating.add(tmp);
                }
                break;
        }
        return listRating.size();
    }
}
