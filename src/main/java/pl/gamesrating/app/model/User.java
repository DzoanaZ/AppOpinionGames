package pl.gamesrating.app.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private String email;
    private String password;
    private int active;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user.id"), inverseJoinColumns = @JoinColumn(name = "role.id"))
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Post> posts;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private List<Rating> ratings;
}
