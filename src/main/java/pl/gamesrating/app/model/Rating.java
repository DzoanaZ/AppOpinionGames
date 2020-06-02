package pl.gamesrating.app.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String type;
    private Double rating;
    private String comment;
    private LocalDateTime ratingDate;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User user;
}
