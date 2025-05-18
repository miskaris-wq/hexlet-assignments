@import exercise.dto.posts.PostsPage
@param PostsPage page

<!DOCTYPE html>
<html>
<head>
    <title>Посты</title>
</head>
<body>
    @if(page.getPosts().isEmpty())
        <p>Нет постов для отображения</p>
    @else
        <ul>
            @for(var post : page.getPosts())
                <li>
                    <a href="/posts/${post.getId()}">${post.getName()}</a>
                </li>
            @endfor
        </ul>

        <div>
            @if(page.getPageNumber() > 1)
                <a href="?page=${page.getPageNumber() - 1}">Предыдущая страница</a>
            @endif

            @if(page.hasNextPage())
                <a href="?page=${page.getNextPageNumber()}">Следующая страница</a>
            @endif
        </div>
    @endif
</body>
</html>
