package pl.gamesrating.app.model.DTO;

public class RatingDTO {
    private Double rating;
    private String comment;

    public RatingDTO() {
    }

    public RatingDTO(Double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
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
}
