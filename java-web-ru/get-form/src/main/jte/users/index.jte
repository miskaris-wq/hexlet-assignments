@param exercise.dto.users.UsersPage page

<!DOCTYPE html>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
    <h1>Поиск пользователей</h1>

    <!-- Поисковая форма с сохранением введенного значения -->
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}"
               placeholder="Имя, фамилия или почта...">
        <input type="submit" value="Найти">
    </form>

    <!-- Результаты поиска -->
    <div class="users">
        @for(var user : page.getUsers())
            <div class="user">
                <h2>${user.getFirstName()}</h2>
                <p>${user.getLastName()}</p>
                <p>${user.getEmail()}</p>
            </div>
        @endfor
    </div>
</body>
</html>