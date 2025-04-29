@import org.example.hexlet.dto.User
@param User user

@template.layout.page(
    title = "Профиль пользователя",
    content = @`
        <h1>${user.getName()}</h1>
        <div>ID: ${user.getId()}</div>
        <div>Email: ${user.getEmail()}</div>
        <a href="/users">Назад к списку</a>
    `
)