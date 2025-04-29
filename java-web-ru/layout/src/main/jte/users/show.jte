@import exercise.dto.User
@param User user

@template.layout.page(
    title = "Профиль пользователя",
    content = @`
        <h1>${user.getName()}</h1>
        <div>
            <p>ID: ${user.getId()}</p>
            <p>Email: ${user.getEmail()}</p>
        </div>
        <a href="/users">Назад к списку</a>
    `
)