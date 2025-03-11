package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> storage;

    public InMemoryKV(Map<String, String> newStorage) {
        this.storage = new HashMap<>(newStorage);
    }

    @Override
    public void set(String key, String value) {
        this.storage.put(key, value);
    }

    @Override
    public void unset(String key) {
        this.storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (this.storage.containsKey(key)) {
            return this.storage.get(key);
        }

        return defaultValue;
    }


    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.storage);
    }
}
// END
