@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    title = "Список пользователей",
    content = @`
        <h1>Пользователи</h1>
        <a href="/users/build">Новый пользователь</a>
        <ul>
            @for(user in page.getUsers())
                <li>
                    <a href="/users/${user.getId()}">
                        ${user.getFirstName()} ${user.getLastName()}
                    </a>
                </li>
            @endfor
        </ul>
    `
)