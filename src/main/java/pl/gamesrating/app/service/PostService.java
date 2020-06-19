package pl.gamesrating.app.service;

import pl.gamesrating.app.model.DTO.PostDTO;
import pl.gamesrating.app.model.Post;
import pl.gamesrating.app.model.User;

import java.io.IOException;
import java.util.List;

public interface PostService {
    List<Post> getNews();

    void savePost(PostDTO postDTO, User user) throws IOException;

    Post findById (Long id);

    List<Post> getAllPosts();

    void delete(Post post);
}
