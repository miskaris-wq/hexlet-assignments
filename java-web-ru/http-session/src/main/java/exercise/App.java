package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        var users = Data.getUsers();

        // BEGIN
        app.get("/users", ctx -> {
            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            int startIndex = (page - 1) * per;
            int endIndex = Math.min(startIndex + per, users.size());

            if (startIndex >= users.size()) {
                ctx.json(List.of());

                return;
            }

            List<Map<String, String>> pageUsers = users.subList(startIndex, endIndex);
            ctx.json(pageUsers);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
