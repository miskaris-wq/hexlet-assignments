package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id"); // Получаем ID из параметра пути
            // Ищем компанию с указанным ID
            var company = COMPANIES.stream()
                    .filter(c -> c.get("id").equals(id)) // Проверяем совпадение ID
                    .findFirst() // Берем первую подходящую компанию
                    .orElseThrow(() -> new NotFoundResponse("Company not found")); // Если не найдено - 404
            ctx.json(company); // Возвращаем найденную компанию в формате JSON
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES); // Возвращаем список всех компаний
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070); // Запускаем сервер на порту 7070
    }
}