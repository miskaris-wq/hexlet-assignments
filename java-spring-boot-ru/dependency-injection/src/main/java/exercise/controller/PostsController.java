package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping(path = "/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    // GET /posts — список всех постов
    @GetMapping(path = "")
    public List<Post> show() {
        return postRepository.findAll();
    }

    // GET /posts/{id} – просмотр конкретного поста
    @GetMapping(path = "/{id}")
    public Post index(@PathVariable long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Post with id " + id + " not found"));
    }

    // POST /posts – создание нового поста
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postRepository.save(post);
    }

    // PUT /posts/{id} – обновление поста
    @PutMapping(path = "/{id}")
    public Post update(@PathVariable long id, @RequestBody Post postData) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Post with id " + id + " not found"));

        post.setTitle(postData.getTitle());
        post.setBody(postData.getBody());

        return postRepository.save(post);
    }

    // DELETE /posts/{id} – удаление поста
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        // Сначала проверяем существование поста
        if (!postRepository.existsById(id)) {
            throw new ResourceNotFoundException("Post with id " + id + " not found");
        }

        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);
    }
}
// END
