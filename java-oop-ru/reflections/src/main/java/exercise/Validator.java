package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Class<?> aClass = address.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        var result = new ArrayList<String>();

        for (var field : declaredFields) {

            if (field.isAnnotationPresent(NotNull.class)) {
                try {

                    field.setAccessible(true);

                    Object value = field.get(address);

                    if (value == null) {
                        result.add(field.getName());
                    }
                } catch (IllegalAccessException e) {

                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    public static Map<String, List<String>> advancedValidate(Address address) {
        Class<?> aClass = address.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        var result = new HashMap<String, List <String>>();

        for (var field : declaredFields) {
            field.setAccessible(true);
            var list = new ArrayList<String>();

            if (field.isAnnotationPresent(NotNull.class)) {
                try {

                    Object value = field.get(address);

                    if (value == null) {
                        list.add("can not be null");

                    }
                } catch (IllegalAccessException e) {

                    e.printStackTrace();
                }
            }
            if(field.isAnnotationPresent(MinLength.class)) {

                try {
                    Object value = field.get(address);
                    if (value != null) {
                        MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                        int minLength = minLengthAnnotation.minLength();
                        if (((String) value).length() < minLength) {
                            list.add("length less than " + minLength);

                        }
                    }
                } catch (IllegalAccessException e) {

                    e.printStackTrace();
                }
            }
            if (!list.isEmpty()) {
                result.put(field.getName(), list);
            }
        }
        return result;
    }
}
// END