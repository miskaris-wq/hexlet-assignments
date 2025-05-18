@import exercise.dto.posts.PostPage
@param PostPage page

<!DOCTYPE html>
<html>
<head>
    <title>${page.getPost().getName()}</title>
</head>
<body>
    <h1>${page.getPost().getName()}</h1>
    <a href="/posts">← Назад к списку</a>

    <div>
        <h3>Содержимое</h3>
        <p>${page.getPost().getBody()}</p>
    </div>

    <div>
        <strong>ID:</strong> ${page.getPost().getId()}
    </div>
</body>
</html>
