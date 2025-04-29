@import org.example.hexlet.dto.UsersPage
@param UsersPage page

@template.layout.page(
    title = "Пользователи",
    content = @`
        <a href="/users/build">New User</a>
        @for(var user : page.getUsers())
            <div>${user.getName()}</div>
        @endfor
    `
)