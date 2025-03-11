package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {

        Map <String, String> swappedData= new HashMap<>();
        for(var key: storage.toMap().keySet()) {
            String newValue = storage.get(key, "default");

            swappedData.put(newValue, key);
            storage.unset(key);
        }



        for(var newKey : swappedData.keySet()) {
            storage.set(newKey, swappedData.get(newKey));
        }


    }
}
// END
//Создайте класс App с публичным статическим методом swapKeyValue().
// Метод принимает на вход объект базы данных и меняет в нём ключи и значения местами.
// swapKeyValue() — полиморфный метод, он может работать с любой реализацией базы данных,
// реализующей интерфейс KeyValueStorage.