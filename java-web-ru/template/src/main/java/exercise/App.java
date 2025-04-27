package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

public final class App {

    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte()); // Подключаем шаблонизатор JTE
        });

        // Обработчик для списка пользователей
        app.get("/users", ctx -> {
            var header = "Список пользователей";
            var page = new UsersPage(USERS, header);
            ctx.render("users/index.jte", model("page", page));
        });

        // Обработчик для конкретного пользователя
        app.get("/users/{id}", ctx -> {
            var id = Long.parseLong(ctx.pathParam("id")); // Получаем ID из URL
            var user = USERS.stream()
                    .filter(u -> u.getId() == id) // Ищем пользователя по ID
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("User not found")); // 404 если не найден
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070); // Запускаем приложение на порту 7070
    }
}
