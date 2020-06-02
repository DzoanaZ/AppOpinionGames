package pl.gamesrating.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String role;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
