<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <header>
        <a href="/">Главная</a>
        <a href="/users">Пользователи</a>
    </header>

    <main>
        @template.content()
    </main>

    <footer>
        <p>© 2025 My App. <a href="https://github.com/miskaris-wq" target="_blank">My GitHub</a></p>
    </footer>
</body>
</html>