@import org.example.hexlet.model.User
@param User user

<html>
    <head>
        <title>${user.getFirstName()}${user.getLastName()}</title>
    </head>
    <body>
        <h1>${course.getName()}${user.getLastName()}</h1>
        <p>${user.getEmail()}</p>
        <a href="/courses">Назад к списку пользователей</a>
    </body>
</html>