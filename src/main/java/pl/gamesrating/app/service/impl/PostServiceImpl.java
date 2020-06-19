package pl.gamesrating.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.gamesrating.app.model.DTO.PostDTO;
import pl.gamesrating.app.model.Post;
import pl.gamesrating.app.model.Rating;
import pl.gamesrating.app.model.User;
import pl.gamesrating.app.repository.CategoryRepository;
import pl.gamesrating.app.repository.PostRepository;
import pl.gamesrating.app.repository.RatingRepository;
import pl.gamesrating.app.service.PostService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Post> getNews() {
        return postRepository.findTop4ByOrderByPublicationDateDesc();

    }

    @Override
    public void savePost(PostDTO postDTO, User user) throws IOException {
        Post newPost = new Post();
        newPost.setAuthor(user);
        newPost.setCategory(categoryRepository.findById(postDTO.getCategoryId()).get());
        newPost.setEditorialRate(Double.valueOf(postDTO.getEditorialRating()));

        Rating rating = new Rating();
        rating.setType(Rating.Type.EDITORIAL);
        rating.setRating(Double.valueOf(postDTO.getEditorialRating()));
        rating.setPost(newPost);
        rating.setUser(user);
        rating.setRatingDate(LocalDateTime.now());

        newPost.setDescription(postDTO.getDescription());
        newPost.setShortDescription(postDTO.getShortDescription());
        newPost.setTitle(postDTO.getTitle());
        newPost.setPublicationDate(LocalDate.now());
        newPost.setImgPath(this.saveFile(postDTO.getImage()));

        postRepository.save(newPost);
        ratingRepository.save(rating);

    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public void delete(Post post) {
        String pathFile = null;
        if (post.getImgPath() != null) {
            pathFile = this.prepareFileDirectory() + post.getImgPath();
        }

        if (pathFile != null) {
            File file = new File(pathFile);
            if (file.delete()) {
                System.out.println("File was deleted:\n" + pathFile);
            }
        }
        postRepository.delete(post);
    }

    private String saveFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        String extension = this.getExtensionByStringHandling(filename).orElse("");

        if (!file.isEmpty()) {
            UUID uuid = UUID.randomUUID();
            filename = "/upload_" + uuid.toString() + (extension.isEmpty() ? "" : "." + extension);
            byte[] bytes = file.getBytes();
            File fsFile = new File(this.prepareFileDirectory() + filename);
            fsFile.createNewFile();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fsFile));
            stream.write(bytes);
            stream.close();
        } else {
            filename = null;
            System.out.println("Uploaded file is empty");
        }
        return filename;
    }

    private String prepareFileDirectory() {
        ClassLoader classLoader = getClass().getClassLoader();
        Path path = Paths.get((classLoader.getResource(".").getPath() + "static/img/files").substring(1));
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path.toString();
    }

    private Optional<String> getExtensionByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }


}
