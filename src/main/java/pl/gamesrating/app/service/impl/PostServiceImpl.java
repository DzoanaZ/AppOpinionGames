package pl.gamesrating.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gamesrating.app.model.Post;
import pl.gamesrating.app.repository.PostRepository;
import pl.gamesrating.app.service.PostService;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Post> getNews() {
        return postRepository.findTop4ByOrderByPublicationDateDesc();

    }
}
