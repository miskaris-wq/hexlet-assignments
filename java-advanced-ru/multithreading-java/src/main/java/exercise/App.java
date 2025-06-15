package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread threadMax = new MaxThread(numbers);
        MinThread threadMin = new MinThread(numbers);
        var result = new HashMap<String, Integer>();

        threadMin.start();
        threadMax.start();

        try {
            threadMax.join();
            threadMin.join();
        } catch (InterruptedException e) {
            System.out.println("Ошибка!");
            Thread.currentThread().interrupt();
        }


        result.put("min", threadMin.getMin());
        result.put("max", threadMax.getMax());
        return result;
    }
    // END
}
