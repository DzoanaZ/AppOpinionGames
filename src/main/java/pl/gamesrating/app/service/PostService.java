package pl.gamesrating.app.service;

import pl.gamesrating.app.model.DTO.PostDTO;
import pl.gamesrating.app.model.Post;
import pl.gamesrating.app.model.User;

import java.util.List;

public interface PostService {
    List<Post> getNews();

    void savePost(PostDTO postDTO, User user);

}
