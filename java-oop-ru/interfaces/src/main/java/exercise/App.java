package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> list, int n) {

        if (n > list.size()) {
                return new ArrayList<>();
        }

        List<Home> sortedList = list.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .toList();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(sortedList.get(i).toString());
        }
        return result;
    }

}
// END
