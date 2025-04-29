@import exercise.dto.UsersPage
@param UsersPage page

@template.layout.page(
    title = "Список пользователей",
    content = @`
        <a href="/users/build">Новый пользователь</a>
        @for(var user : page.getUsers())
            <div>${user.getName()}</div>
        @endfor
    `
)