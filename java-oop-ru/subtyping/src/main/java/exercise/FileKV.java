package exercise;

import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {

    private String pathToFile;
    private Map<String, String> storage;

    public FileKV(String pathToFile, Map<String, String> initialData) {
        this.pathToFile = pathToFile;
        this.storage = loadStorage();


        if (this.storage.isEmpty()) {
            this.storage = new HashMap<>(initialData);
            saveStorage();
        }
    }


    private Map<String, String> loadStorage() {
        String json = Utils.readFile(pathToFile);
        if (json.isEmpty()) {
            return new HashMap<>();
        }
        return Utils.deserialize(json);
    }

    private void saveStorage() {
        String json = Utils.serialize(storage);
        Utils.writeFile(pathToFile, json);
    }

    @Override
    public void set(String key, String value) {
        this.storage.put(key, value);
        saveStorage();
    }

    @Override
    public void unset(String key) {
        this.storage.remove(key);
        saveStorage();
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.storage);
    }
}
