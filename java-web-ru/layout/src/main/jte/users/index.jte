@import exercise.dto.UsersPage
@param UsersPage page

@template.layout.page(
    title = "Список пользователей",
    content = @`
        <h1>Пользователи</h1>
        <a href="/users/build">Создать нового</a>
        <ul>
            @for(var user : page.getUsers())
                <li>
                    <a href="/users/${user.getId()}">${user.getName()}</a>
                </li>
            @endfor
        </ul>
    `
)