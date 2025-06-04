package exercise.controller.users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    private final List<Post> posts = new ArrayList<>(Data.getPosts());

    @GetMapping("/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable("id") int userId) {
        return posts.stream()
                .filter(post -> post.getUserId() == userId)
                .collect(Collectors.toList());
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(
            @PathVariable("id") int userId,
            @RequestBody Post newPost
    ) {
        newPost.setUserId(userId);
        posts.add(newPost);
        return newPost;
    }
}

// END
