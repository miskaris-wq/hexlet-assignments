@import exercise.dto.users.UserPage
@param UserPage page

<!DOCTYPE html>
<html>
    <head>
        <title>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</title>
        <!-- Подключаем Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <div class="d-flex justify-content-between align-items-center mb-4">
                <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
                <a href="/users" class="btn btn-outline-secondary">← Назад к списку</a>
            </div>

            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Данные пользователя</h5>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <strong>ID:</strong> ${page.getUser().getId()}
                        </li>
                        <li class="list-group-item">
                            <strong>Имя:</strong> ${page.getUser().getFirstName()}
                        </li>
                        <li class="list-group-item">
                            <strong>Фамилия:</strong> ${page.getUser().getLastName()}
                        </li>
                        <li class="list-group-item">
                            <strong>Email:</strong> ${page.getUser().getEmail()}
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>
