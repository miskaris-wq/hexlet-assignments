@import exercise.dto.users.UsersPage
@param UsersPage page

<!DOCTYPE html>
<html>
    <head>
        <title>Пользователи</title>
        <!-- Подключаем Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h1>${page.getHeader()}</h1>

            @if(page.getUsers().isEmpty())
                <div class="alert alert-info">Нет пользователей для отображения</div>
            @else
                <table class="table table-striped">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Имя</th>
                            <th>Фамилия</th>
                            <th>Email</th>
                            <th>Действия</th>
                        </tr>
                    </thead>
                    <tbody>
                        @for(var user : page.getUsers())
                            <tr>
                                <td>${user.getId()}</td>
                                <td>${user.getFirstName()}</td>
                                <td>${user.getLastName()}</td>
                                <td>${user.getEmail()}</td>
                                <td>
                                    <a href="/users/${user.getId()}" class="btn btn-sm btn-primary">
                                        Просмотр
                                    </a>
                                </td>
                            </tr>
                        @endfor
                    </tbody>
                </table>
            @endif
        </div>
    </body>
</html>
