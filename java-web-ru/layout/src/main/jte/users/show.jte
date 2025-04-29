@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    title = "Профиль пользователя",
    content = @`
        <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
        <div>
            <p>ID: ${page.getUser().getId()}</p>
            <p>Email: ${page.getUser().getEmail()}</p>
        </div>
        <a href="/users">Назад к списку</a>
    `
)