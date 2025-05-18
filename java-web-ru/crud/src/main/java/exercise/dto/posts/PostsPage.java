package exercise.dto.posts;

import java.util.ArrayList;
import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@Getter
@AllArgsConstructor
public class PostsPage {
    private List<Post> posts;
    private int pageNumber;
    private int totalPages;

    public boolean hasNextPage() {
        return pageNumber < totalPages;
    }

    public boolean hasPreviousPage() {
        return pageNumber > 1;
    }

    public int getNextPageNumber() {
        return pageNumber + 1;
    }

    public int getPreviousPageNumber() {
        return pageNumber - 1;
    }
}
// END


