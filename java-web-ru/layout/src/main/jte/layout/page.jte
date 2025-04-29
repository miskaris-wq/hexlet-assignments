@import gg.jte.Content
@param Content content
@param String title = "My App"

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${title}</title>
</head>
<body>
    <header>
        <nav>
            <a href="/">Главная</a>
            <a href="/users">Пользователи</a>
        </nav>
    </header>

    <main>
        ${content}
    </main>

    <footer>
        <p>© 2025 My App |
           <a href="https://github.com/yourusername" target="_blank">My GitHub</a>
        </p>
    </footer>
</body>
</html>